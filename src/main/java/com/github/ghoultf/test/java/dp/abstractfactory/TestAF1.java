package com.github.ghoultf.test.java.dp.abstractfactory;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 新需求，增加cache3，没给product创建的地方都需要增加
 *
 * @author ghoul
 * @date 2023/06/14
 */
public class TestAF1 {

    private static List<Object> cache1 = new ArrayList<>();
    private static List<Object> cache2 = new ArrayList<>();
    // add cache3
    private static List<Object> cache3 = new ArrayList<>();

    @Data
    static class Product11 {
        private int a;
        private int b;
        private int c;
    }

    public static void main(String[] args) {
        Product11 p111 = new Product11();
        if (cache1.contains(p111)) {
            cache1.remove(p111);
            cache1.add(p111);
        }
        if (cache2.contains(p111)) {
            cache2.remove(p111);
            cache2.add(p111);
        }
        // add cache3
        if (cache3.contains(p111)) {
            cache3.remove(p111);
            cache3.add(p111);
        }

        Product11 p112 = new Product11();
        if (cache1.contains(p112)) {
            cache1.remove(p112);
            cache1.add(p112);
        }
        if (cache2.contains(p112)) {
            cache2.remove(p112);
            cache2.add(p112);
        }
        // add cache3
        if (cache3.contains(p112)) {
            cache3.remove(p112);
            cache3.add(p112);
        }
        printProduct(p111);
        printProduct(p112);
    }

    static void printProduct(Product11 p) {
        System.out.println(p.a + "" + p.b);
    }
}
