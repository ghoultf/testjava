package com.github.ghoultf.test.java.singleton;

public class TestLazy4InnerClass {

    private static TestLazy4InnerClass instance;

    private TestLazy4InnerClass() {

    }

    /**
     * 锁的粒度大，无论instance是否为null，同时获取都会锁定
     *
     * @return the instance
     * @author ghoul
     * @date 2023/06/16
     */
    public static synchronized TestLazy4InnerClass getInstance() {
        if (instance == null) {
            instance = new TestLazy4InnerClass();
        }
        return instance;
    }

}
