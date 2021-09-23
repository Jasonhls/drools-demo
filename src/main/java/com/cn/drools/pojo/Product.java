package com.cn.drools.pojo;

import lombok.Data;

/**
 * @Author: helisen
 * @Date 2021/9/22 9:37
 * @Description:
 */
@Data
public class Product {
    public static final String DIAMOND = "DIAMOND";

    public static final String GOLD = "GOLD";

    private String type;

    private int discount;

}
