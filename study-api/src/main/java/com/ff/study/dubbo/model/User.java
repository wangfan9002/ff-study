package com.ff.study.dubbo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 深谷
 * @serial 2017/10/18 下午4:09.
 */
@Data
public class User implements Serializable {

    private static Long serialVersionUID = 1L;

    private Long id;
    private int age;
    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
