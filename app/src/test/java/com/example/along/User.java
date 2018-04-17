package com.example.along;

import java.lang.reflect.ParameterizedType;

/**
 * Title:
 * <p>
 * Description:
 * </p>
 * Author dragon.
 * Date 2018/4/16 13:40
 */

public abstract class User<T> {

    public User() {

    }

    public abstract void go();

    public void test() {
        Class <T> entityClass = (Class <T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        System.out.println(entityClass);
    }

}
