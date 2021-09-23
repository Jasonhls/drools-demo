package com.cn.drools.pojo;

import java.util.List;

/**
 * @Author: helisen
 * @Date 2021/9/22 10:24
 * @Description:
 */
public class Message {
    public static final int HELLO   = 0;
    public static final int GOODBYE = 1;

    //字段必须是public的
    public String message;
    //字段必须是public的
    public int status;

    public Message() {

    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public static Message doSomething(Message message) {
        return message;
    }

    public boolean isSomething(String msg,
                               List<Object> list) {
        list.add( this );
        return this.message.equals( msg );
    }
}
