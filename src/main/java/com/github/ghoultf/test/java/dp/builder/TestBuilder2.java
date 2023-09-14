package com.github.ghoultf.test.java.dp.builder;

import java.io.Serializable;

public class TestBuilder2 implements Serializable {

    public static void main(String[] args) throws Exception {

        NutritionFacts cocaCola = new EntityCreator<>(NutritionFacts.class, 240, 8).setValue("calories", 100)
            .setValue("sodium", 35).setValue("carbohydrate", 27)
            /*.setValue(NutritionFacts::getFat, 111)*/
            .build();
        System.out.println(cocaCola);
    }
}
