package com.github.ghoultf.test.java.function;

import java.util.function.Function;

public class TestFunction {
    public static void main(String[] args) {

        Function<String, Integer> f = String::length;
        int length = f.apply("Hello");
    }
}
