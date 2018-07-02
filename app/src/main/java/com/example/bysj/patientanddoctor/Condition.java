package com.example.bysj.patientanddoctor;

import java.io.Serializable;

/**
 * Created by Qian on 2018/6/1.
 */
public class Condition implements Serializable {

    private Integer id;
    private String symptoms;
    private String time;
    private String detial;
    private Integer userid;

    public Condition() {
    }

    public Condition(Integer id, String symptoms, String time, String detial, Integer userid) {
        this.id = id;
        this.symptoms = symptoms;
        this.time = time;
        this.detial = detial;
        this.userid = userid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDetial() {
        return detial;
    }

    public void setDetial(String detial) {
        this.detial = detial;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
