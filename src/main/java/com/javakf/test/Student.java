package com.javakf.test;

import java.io.Serializable;

/**
 * @Author: helisen
 * @Date 2021/9/23 14:55
 * @Description:
 */
public class Student implements Serializable {
    static final long serialVersionUID = 1L;

    private java.lang.Long id;
    private java.lang.String name;
    private int age;

    public Student() {
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(java.lang.Long id, java.lang.String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
