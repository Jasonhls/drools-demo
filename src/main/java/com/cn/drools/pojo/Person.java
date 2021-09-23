package com.cn.drools.pojo;

import lombok.Data;

/**
 * @Author: helisen
 * @Date 2021/9/17 12:34
 * @Description:
 */
@Data
public class Person {
    private int sex;

    private String fullName;

    private String drlType;

    private String country;

    public Person(int sex, String fullName, String drlType, String country) {
        this.sex = sex;
        this.fullName = fullName;
        this.drlType = drlType;
        this.country = country;
    }

    public Person() {
    }
}
