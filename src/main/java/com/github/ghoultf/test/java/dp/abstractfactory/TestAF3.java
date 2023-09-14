package com.github.ghoultf.test.java.dp.abstractfactory;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * 老需求增加产品Product22，新增加Product后，printProduct不会变
 * 
 * 新需求，增加新的产品
 * 
 * @author ghoul
 * @date 2023/06/14
 */
public class TestAF3 {

    private static List<Object> cache1 = new ArrayList<>();
    private static List<Object> cache2 = new ArrayList<>();
    private static List<Object> cache3 = new ArrayList<>();

    /**
     * 每增加product后，printProduct都不会变
     *
     * @author ghoul
     * @date 2023/06/14
     */
    @Data
    static abstract class Products {
        protected int a;
        protected int b;
    }

    @Data
    static class Product11 extends Products {
        /*
        private int a;
        private int b;
        private int c;
        private int c1; */
        private int c;
        private int c1;
    }

    // 新需求，增加Product12的创建
    // 目前的问题是，printProduct方法强依赖具体的product类11或22
    @Data
    static class Product12 extends Products {
        /*
        private int a;
        private int b;
        private int c;
        private int c2;*/
        private int c;
        private int c2;
    }

    @Data
    static class Product21 extends Products {
        private int d;
        private int d1;
    }

    @Data
    static class Product22 extends Products {
        private int d;
        private int d2;
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
        /*static TestAF2.Product11 create() {
            TestAF2.Product11 p = new TestAF2.Product11();
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
        
        static TestAF2.Product22 create22() {
            TestAF2.Product22 p = new TestAF2.Product22();
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
        }*/
        Products create(String type) {
            Products p;
            switch (type) {
                case "11":
                    p = new Product11();
                    break;
                case "12":
                    p = new Product12();
                    break;
                // 还是需要改动create方法
                case "21":
                    p = new Product21();
                    break;
                case "22":
                    p = new Product22();
                    break;
                default:
                    throw new NotImplementedException();
            }
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
        Factory1 factory1 = new Factory1();
        Products p111 = factory1.create("11");
        Products p112 = factory1.create("11");
        printProduct(p111);
        printProduct(p112);
        Products p12 = factory1.create("12");
        printProduct(p12);

        Products p21 = factory1.create("21");
        printProduct(p21);
        Products p22 = factory1.create("22");
        printProduct(p22);
    }

    /*static void printProduct(TestAF2.Product11 p) {
        System.out.println(p.a + "" + p.b);
    }
    
    static void printProduct(TestAF2.Product22 p) {
        System.out.println(p.a + "" + p.b);
    }*/

    static void printProduct(Products p) {
        System.out.println(p.a + "" + p.b);
    }
}
