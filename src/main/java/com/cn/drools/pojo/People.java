package com.cn.drools.pojo;

import lombok.Data;

/**
 * @Author: helisen
 * @Date 2021/9/17 12:34
 * @Description:
 */
@Data
public class People {
    private int sex;

    private String name;

    private String drlType;

    public People(int sex, String name, String drlType) {
        this.sex = sex;
        this.name = name;
        this.drlType = drlType;
    }

    public People() {
    }
}
