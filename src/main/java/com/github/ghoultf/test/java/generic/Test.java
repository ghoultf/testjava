package com.github.ghoultf.test.java.generic;

public class Test {
    public static void main(String[] args) {
        Sub sub = new Sub();
        MyGeneric<IParent> ppp = new MyGeneric<>(sub);

        MyGeneric<ISub> sss = (MyGeneric<ISub>)((MyGeneric)ppp);
        System.out.println(sss);

    }

    interface IParent {}

    interface ISub extends IParent {}

    static class Sub implements ISub {}

    abstract static class GenericBase<E extends IParent> {
        E e;

        public GenericBase(E e) {
            this.e = e;
        }
    }

    static class MyGeneric<E extends IParent> extends GenericBase<E> {

        public MyGeneric(E iParent) {
            super(iParent);
        }
    }
}
