package com.example.creditcenter.Dao;

import com.example.creditcenter.Controller.AuditController;
import org.apache.log4j.Logger;

/**
 * @param
 * @param
 * @description: 选择使用主从数据源
 * @return:
 * @author: liufangyuan
 * @date: 2020/07/05
*/

public class DbContextHolder {
    private static Logger log = Logger.getLogger(AuditController.class);

    public static final String readDataSource = "read";

    public static final String writeDataSource = "write";

    private static ThreadLocal<String> ds = new ThreadLocal<>();

    public static void setDataSource(String dataSource){
        log.error(dataSource);
        ds.set(dataSource);
    }

    public static String getDataSource(){
        return ds.get();
    }

    public static void clearDataSource(){
        ds.remove();
    }

}
