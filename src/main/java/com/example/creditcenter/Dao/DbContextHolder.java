package com.example.creditcenter.Dao;

import java.util.HashMap;

/**
 * @param
 * @param
 * @description: 选择使用主从数据源
 * @return:
 * @author: liufangyuan
 * @date: 2020/07/05
*/

public class DbContextHolder {

    public static final String devDataSource = "dev";

    public static final String masterDataSource = "master";

    private static ThreadLocal<String> ds = new ThreadLocal<>();

    public static void setDataSource(String dataSource){
        System.out.println("setDataSource:"+dataSource);
        ds.set(dataSource);
    }

    public static String getDataSource(){
        return ds.get();
    }

    public static void clearDataSource(){
        ds.remove();
        System.out.println("clearDataSource:"+ds.get());
    }
}
