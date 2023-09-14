package com.github.ghoultf.test.java.clone;

import java.util.Arrays;
import java.util.List;

import lombok.Data;

public class TestClone {

    @Data
    static class B {
        private int bb;
        private String ba;
    }

    @Data
    static class A implements Cloneable {
        private int aa;
        private String ab;
        private List<B> acs;
        private List<Integer> ads;
        private List<String> aes;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        B b1 = new B();
        b1.setBb(3333);
        b1.setBa("ccc");
        B b2 = new B();
        b2.setBb(222);
        b2.setBa("bbb");
        A a = new A();
        a.setAa(111);
        a.setAb("aaaaaa");
        a.setAcs(Arrays.asList(b1, b2));
        a.setAds(Arrays.asList(1, 2, 3));
        a.setAes(Arrays.asList("1", "2", "3"));

        Object clone = a.clone();
        // clone的这个属性更改
        b1.setBa("123123123");
        // clone这两个属性不更改
        a.setAa(1231231231);
        a.setAb("1231231231");
        System.out.println(a);
    }
}
