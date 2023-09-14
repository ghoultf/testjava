package com.github.ghoultf.test.java.singleton;

public class TestLazy2Synchronized {

    private static TestLazy2Synchronized instance;

    private TestLazy2Synchronized() {

    }

    /**
     * 锁的粒度大，无论instance是否为null，同时获取都会锁定
     *
     * @return the instance
     * @author ghoul
     * @date 2023/06/16
     */
    public static synchronized TestLazy2Synchronized getInstance() {
        if (instance == null) {
            instance = new TestLazy2Synchronized();
        }
        return instance;
    }
}
