package com.github.ghoultf.test.java.dp.builder;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

public class TestBuilder {
    private static List<Object> cache1 = new ArrayList<>();
    private static List<Object> cache2 = new ArrayList<>();

    @Data
    static class Product {
        private int a;
        private int b;
    }

    static abstract class AbstractBuilder {
        public abstract AbstractBuilder set1(int i);

        public abstract AbstractBuilder set2(int i);

        public abstract Object build();
    }

    /**
     * 1.创建有顺序 <br>
     * 2.可创建出不同的对象 <br>
     * 3.内部结构需要了解
     *
     * @author ghoul
     * @date 2023/06/14
     */
    static class Builder extends AbstractBuilder {
        private Product p = new Product();

        @Override
        public AbstractBuilder set1(int i) {
            p.a = i;
            return this;
        }

        @Override
        public AbstractBuilder set2(int i) {
            p.b = i;
            return this;

        }

        @Override
        public Object build() {
            if (cache1.contains(p)) {
                cache1.remove(p);
                cache1.add(p);
            }
            if (cache2.contains(p)) {
                cache2.remove(p);
                cache2.add(p);
            }
            return p;
        }
    }

    private static AbstractBuilder builder = new Builder();

    public static void main(String[] args) {
        Object build = builder.set1(1).set2(2).build();
    }

}
