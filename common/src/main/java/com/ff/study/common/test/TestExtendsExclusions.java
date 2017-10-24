package com.ff.study.common.test;


import com.google.common.util.concurrent.Monitor;
import io.terminus.common.mysql.dao.MyBatisDao;

import java.io.IOException;

/**
 * Created by 深谷 on 2017/9/26 上午10:17.
 */
public class TestExtendsExclusions {


    public void doTest() {
    }

    public static void main(String[] args) {
        String str = "重新竞价 情况说明：重新竞价";
        int index = str.indexOf("：");
        if (index != -1) {
            str = str.substring(index+1);
        }
        System.out.println("str==" + str);
    }
}
