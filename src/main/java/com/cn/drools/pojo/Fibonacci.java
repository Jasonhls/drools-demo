package com.cn.drools.pojo;

/**
 * @Author: helisen
 * @Date 2021/9/22 16:01
 * @Description:
 */
public class Fibonacci {
    public int sequence;
    public long value;

    public Fibonacci(final int sequence) {
        this.sequence = sequence;
        this.value = -1;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
