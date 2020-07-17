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

    @ChoseDataSource("dev")
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
