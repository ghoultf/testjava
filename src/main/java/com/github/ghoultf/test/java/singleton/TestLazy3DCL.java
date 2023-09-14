package com.github.ghoultf.test.java.singleton;

public class TestLazy3DCL {

    /**
     * todo：volatile关键字的解释
     * 
     * @author ghoul
     * @date 2023/06/16
     */
    private volatile static TestLazy3DCL instance;

    private TestLazy3DCL() {

    }

    /**
     * 缩小锁的粒度
     * 
     * 需要double check lock，双层检测锁定
     *
     * @return the instance
     * @author ghoul
     * @date 2023/06/16
     */
    public static TestLazy3DCL getInstance() {
        if (instance == null) {
            synchronized (TestLazy3DCL.class) {
                if (instance == null) {
                    instance = new TestLazy3DCL();
                }
            }
        }
        return instance;
    }
}
