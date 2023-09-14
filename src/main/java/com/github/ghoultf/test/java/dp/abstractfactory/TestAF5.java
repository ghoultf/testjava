package com.github.ghoultf.test.java.dp.abstractfactory;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * 老需求，我只需要使用一套product系列
 * 
 * <p>
 * <b>总结：</b><br>
 * 1.客户端不依赖具体的工厂和产品，而依赖与抽象工厂和抽象产品<br>
 * 2.将产品的生产过程独立控制<br>
 * 3.每增加一个产品，增加响应的工厂<br>
 * 4.具体的工厂和具体的产品强耦合<br>
 *
 * 高内聚：产品生产的过程<br>
 * 低耦合：<br>
 * 1.客户端与生产过程<br>
 * 2.客户端与产品<br>
 * 3.客户端与工厂
 * 
 * @author ghoul
 * @date 2023/06/14
 */
public class TestAF5 {

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
    static abstract class AbstractProduct1 extends Products {
        protected int c;
    }

    @Data
    static class Product11 extends AbstractProduct1 {
        // private int c;
        private int c1;
    }

    // 新需求，增加Product22的创建
    // 目前的问题是，printProduct方法强依赖具体的product类11或22
    @Data
    static class Product12 extends AbstractProduct1 {
        // private int c;
        private int c2;
    }

    @Data
    static abstract class AbstractProduct2 extends Products {
        protected int d;
    }

    @Data
    static class Product21 extends AbstractProduct2 {
        // private int d;
        private int d1;
    }

    @Data
    static class Product22 extends AbstractProduct2 {
        // private int d;
        private int d2;
    }

    static abstract class AbstractFactory {
        Products createProduct(String type) {
            Products p = create(type);
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
            }
            return p;
        }

        protected abstract Products create(String type);
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
    static class Factory1 extends AbstractFactory {
        @Override
        protected Products create(String type) {
            AbstractProduct1 p;
            switch (type) {
                case "1":
                    p = new Product11();
                    break;
                case "2":
                    p = new Product12();
                    break;
                default:
                    throw new NotImplementedException();
            }
            /*if (cache1.contains(p)) {
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
            }*/
            return p;
        }
    }

    /**
     * 使用一个新类去创建product2x
     *
     * @author ghoul
     * @date 2023/06/14
     */
    static class Factory2 extends AbstractFactory {
        @Override
        protected Products create(String type) {
            AbstractProduct2 p;
            switch (type) {
                case "1":
                    p = new Product21();
                    break;
                case "2":
                    p = new Product22();
                    break;
                default:
                    throw new NotImplementedException();
            }
            /*if (cache1.contains(p)) {
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
            }*/
            return p;
        }
    }

    private static AbstractFactory factory;

    public static void main(String[] args) {
        /*
        Factory1 factory1 = new Factory1();
        Products p111 = factory1.create("11");
        Products p112 = factory1.create("11");
        printProduct(p111);
        printProduct(p112);
        Products p12 = factory1.create("12");
        printProduct(p12);
        
        Factory2 factory2 = new Factory2();
        Products p21 = factory2.create("21");
        printProduct(p21);
        Products p22 = factory2.create("22");
        printProduct(p22);*/
        Products p1 = factory.create("1");
        printProduct(p1);
        Products p2 = factory.create("2");
        printProduct(p2);

    }

    static void printProduct(Products p) {
        System.out.println(p.a + "" + p.b);
    }

    static void printProduct1(AbstractProduct1 p) {
        System.out.println(p.a + "" + p.b + "" + p.c);
    }

    static void printProduct2(AbstractProduct2 p) {
        System.out.println(p.a + "" + p.b + "" + p.d);
    }
}
