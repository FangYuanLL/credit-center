package com.example.creditcenter.Model;

import com.example.creditcenter.Dao.ChoseDataSource;

/*
 * 审核表
 */
public class Audit {

    int id;
    int userid;
    String result;
    String time;
    String serialnumber;//流水号
    int platform;//平台号

    public Audit(){

    }

    public Audit( int userid, String result, String time) {
        this.userid = userid;
        this.result = result;
        this.time = time;
    }

    public Audit(int id, int userid, String result, String time) {
        this.id = id;
        this.userid = userid;
        this.result = result;
        this.time = time;
    }

    public Audit(int userid, String result, String time, String serialnumber, int platform) {
        this.userid = userid;
        this.result = result;
        this.time = time;
        this.serialnumber = serialnumber;
        this.platform = platform;
    }

    public Audit(int id, int userid, String result, String time, String serialnumber, int platform) {
        this.id = id;
        this.userid = userid;
        this.result = result;
        this.time = time;
        this.serialnumber = serialnumber;
        this.platform = platform;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
