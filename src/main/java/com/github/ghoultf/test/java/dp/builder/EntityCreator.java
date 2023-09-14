package com.github.ghoultf.test.java.dp.builder;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.function.Function;

public class EntityCreator<T> {

    private Class<T> classInstance;
    private T entityObj;

    public EntityCreator(Class<T> classInstance, Object... initParams) throws Exception {
        this.classInstance = classInstance;
        Class<?>[] paramTypes = new Class<?>[initParams.length];
        for (int index = 0, length = initParams.length; index < length; index++) {
            String checkStr = initParams[index].getClass().getSimpleName();
            if (checkStr.contains("Integer")) {
                paramTypes[index] = int.class;
            }
            if (checkStr.contains("Double")) {
                paramTypes[index] = double.class;
            }
            if (checkStr.contains("Boolean")) {
                paramTypes[index] = boolean.class;
            }
            if (checkStr.contains("String")) {
                paramTypes[index] = initParams[index].getClass();
            }
        }
        Constructor<T> constructor = classInstance.getDeclaredConstructor(paramTypes);
        constructor.setAccessible(true);
        this.entityObj = constructor.newInstance(initParams);
    }

    public EntityCreator<T> setValue(String paramName, Object paramValue) throws Exception {
        Field field = classInstance.getDeclaredField(paramName);
        field.setAccessible(true);
        field.set(entityObj, paramValue);
        return this;
    }

    public EntityCreator<T> setValue(Function<T, ?> func, Object paramValue) throws Exception {
        Method method = func.getClass().getDeclaredMethod("writeReplace");
        method.setAccessible(true);
        SerializedLambda serializedLambda = (SerializedLambda)method.invoke(func);
        String implMethodName = serializedLambda.getImplMethodName();
        // Field field = classInstance.getDeclaredField(paramName);
        // field.setAccessible(true);
        // field.set(entityObj, paramValue);
        return this;
    }

    public T build() {
        return entityObj;
    }
}
