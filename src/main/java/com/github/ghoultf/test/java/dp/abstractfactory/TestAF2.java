package com.github.ghoultf.test.java.dp.abstractfactory;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 老需求增加cache3，内聚了创建方法，只在创建的地方增加即可
 * 
 * 新需求增加产品Product12
 *
 * @author ghoul
 * @date 2023/06/14
 */
public class TestAF2 {

    private static List<Object> cache1 = new ArrayList<>();
    private static List<Object> cache2 = new ArrayList<>();
    private static List<Object> cache3 = new ArrayList<>();

    @Data
    static class Product11 {
        private int a;
        private int b;
        private int c;
        private int c1;
    }

    // 新需求，增加Product12的创建
    // 目前的问题是，printProduct方法强依赖具体的product类11或22
    @Data
    static class Product12 {
        private int a;
        private int b;
        private int c;
        private int c2;
    }

    /**
     * 内聚了创建方法 <br>
     * 1.创建方法变动易于(统一)修改 <br>
     * 2.对外界隐藏了细节 <br>
     * 3.增加复用性
     *
     * @author ghoul
     * @date 2023/06/14
     */
    static class Factory1 {
        Product11 create() {
            Product11 p = new Product11();
            if (cache1.contains(p)) {
                cache1.remove(p);
                cache1.add(p);
            }
            if (cache2.contains(p)) {
                cache2.remove(p);
                cache2.add(p);
            }
            if (cache3.contains(p)) {
                cache3.remove(p);
                cache3.add(p);
            }
            return p;
        }

        Product12 create12() {
            Product12 p = new Product12();
            if (cache1.contains(p)) {
                cache1.remove(p);
                cache1.add(p);
            }
            if (cache2.contains(p)) {
                cache2.remove(p);
                cache2.add(p);
            }
            if (cache3.contains(p)) {
                cache3.remove(p);
                cache3.add(p);
            }
            return p;
        }
    }

    public static void main(String[] args) {
        // TestAF1.Product11 p111 = new TestAF1.Product11();
        // if (cache1.contains(p111)) {
        // cache1.remove(p111);
        // cache1.add(p111);
        // }
        // if (cache2.contains(p111)) {
        // cache2.remove(p111);
        // cache2.add(p111);
        // }
        // // add cache3
        // if (cache3.contains(p111)) {
        // cache3.remove(p111);
        // cache3.add(p111);
        // }
        //
        // TestAF1.Product11 p112 = new TestAF1.Product11();
        // if (cache1.contains(p112)) {
        // cache1.remove(p112);
        // cache1.add(p112);
        // }
        // if (cache2.contains(p112)) {
        // cache2.remove(p112);
        // cache2.add(p112);
        // }
        // // add cache3
        // if (cache3.contains(p112)) {
        // cache3.remove(p112);
        // cache3.add(p112);
        // }
        // printProduct(p111);
        // printProduct(p112);
        Factory1 factory1 = new Factory1();
        Product11 p111 = factory1.create();
        Product11 p112 = factory1.create();
        printProduct(p111);
        printProduct(p112);
        Product12 p12 = factory1.create12();
        printProduct(p12);

    }

    static void printProduct(Product11 p) {
        System.out.println(p.a + "" + p.b);
    }

    static void printProduct(Product12 p) {
        System.out.println(p.a + "" + p.b);
    }
}
