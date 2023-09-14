package com.github.ghoultf.test.java.dp;

public class TestAdapter {

    class Client {
        private AbstractTarget abstractTarget;

        void perform() {

        }
    }

    abstract class AbstractTarget {
        abstract void Request();
    }

    class Adaptee {
        void UniqueRequest() {
            System.out.println("UniqueRequest");
        };
    }

    class Adapter extends AbstractTarget {
        private Adaptee adaptee;

        @Override
        void Request() {
            adaptee.UniqueRequest();
        }
    }

}
