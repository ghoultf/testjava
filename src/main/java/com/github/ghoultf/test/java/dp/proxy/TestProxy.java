package com.github.ghoultf.test.java.dp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String[] args) {
        IFly bird = new Bird();
        ProxyForIFly proxyForIFly = new ProxyForIFly();
        proxyForIFly.setiFly(bird);

        IFly iFly = (IFly)Proxy.newProxyInstance(IFly.class.getClassLoader(), new Class[] {IFly.class}, proxyForIFly);
        iFly.fly("abc");
    }
}

interface IFly {

    /**
     * Fly.
     */
    void fly(String param);
}

class Bird implements IFly {
    @Override
    public void fly(String param) {
        System.out.println("fly " + param);
    }
}

class ProxyForIFly implements InvocationHandler {

    private IFly iFly;

    /*public ProxyForIFly(IFly iFly) {
        this.iFly = iFly;
    }*/
    public ProxyForIFly() {}

    public void setiFly(IFly iFly) {
        this.iFly = iFly;
    }

    /**
     * Instantiates a new My invocation handler.
     *
     * @param proxy
     *            这个是代理的对象
     * @param method
     *            xxx
     * @param args
     *            xxx
     * @author ghoul
     * @date 2023/06/29
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoking " + method.getName());
        System.out.println("Proxy class: " + proxy.getClass().getName());
        Object result = method.invoke(iFly, args);
        System.out.println("After invoking " + method.getName());
        // factory,singleton,builder,abstractFactory
        // decoratorPattern, proxyPattern, AdapterPattern, flyweightPattern, bridgePattern, observerPattern,
        // templatePattern
        // , iteratorPattern,
        return result;
        // beandefination, beanFactory, applicationContext,beanFactoryPostProcessor,beanPostProcessor
    }
}
