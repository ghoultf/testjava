package com.github.ghoultf.test.java.singleton;

/**
 * 类加载的时候就初始化<br>
 * 优点：无锁<br>
 * 缺点：不用的时候浪费内存
 *
 * @author ghoul
 * @date 2023/06/16
 */
public class TestHungry {

    private static TestHungry instance = new TestHungry();

    private TestHungry() {
        // 反射仍可以调用构造方法，需要+check逻辑
    }

    public static TestHungry getInstance() {
        return instance;
    }
}
