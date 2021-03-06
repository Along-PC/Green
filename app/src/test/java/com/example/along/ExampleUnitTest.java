package com.example.along;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        System.out.println(String.class+"~~~~");

        Student student = new Student();
        User<Student> studentUser = new User<Student>() {
            @Override
            public void go() {
                System.out.println("....");
            }
        };
        //方法中打印泛型的class对象

        studentUser.test();


        System.out.println(User.class+"~~~~");

        assertEquals(4, 2 + 2);
    }
}