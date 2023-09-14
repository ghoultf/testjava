package com.github.ghoultf.test.java.singleton;

/**
 * 使用的时候才初始化
 *
 * @author ghoul
 * @date 2023/06/16
 */
public class TestLazy1Issue {

    private static TestLazy1Issue instance;

    private TestLazy1Issue() {

    }

    /**
     * 存在线程安全问题
     *
     * @return the instance
     * @author ghoul
     * @date 2023/06/16
     */
    public static TestLazy1Issue getInstance() {
        if (instance == null) {
            instance = new TestLazy1Issue();
        }
        return instance;
    }
}
