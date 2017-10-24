package com.ff.study.dubbo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 深谷
 * @serial 2017/10/19 下午1:00.
 */
@Data
public class Order implements Serializable {

    private static Long serialVersionUID = 1L;
    private Long id;
    private Date createDate;
    private String title;
}
