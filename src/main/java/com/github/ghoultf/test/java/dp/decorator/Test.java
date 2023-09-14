package com.github.ghoultf.test.java.dp.decorator;

public class Test {
    interface Subject {
        void request();
    }

    class RealSubject implements Subject {
        @Override
        public void request() {
            // 业务逻辑
        }
    }

    class Decorator implements Subject {
        private Subject subject;

        public Decorator(Subject subject) {
            this.subject = subject;
        }

        @Override
        public void request() {
            // 前置处理
            subject.request();
            // 后置处理
        }
    }
}
