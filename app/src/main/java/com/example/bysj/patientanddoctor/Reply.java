package com.example.bysj.patientanddoctor;

/**
 * Created by Qian on 2018/6/14.
 */
public class Reply {

    private Integer id;
    private String content;
    private  Integer cid;
    private  Integer uid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Reply() {
    }

    public Reply(String content, Integer cid, Integer uid) {
        this.content = content;
        this.cid = cid;
        this.uid = uid;
    }
}
