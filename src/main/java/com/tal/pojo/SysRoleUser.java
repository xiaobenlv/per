package com.tal.pojo;

import java.util.Date;

public class SysRoleUser {
    private Integer id;

    private Integer uid;

    private Integer rid;

    private String operator;

    private Date operatetime;

    private String operateip;

    public SysRoleUser(Integer id, Integer uid, Integer rid, String operator, Date operatetime, String operateip) {
        this.id = id;
        this.uid = uid;
        this.rid = rid;
        this.operator = operator;
        this.operatetime = operatetime;
        this.operateip = operateip;
    }

    public SysRoleUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(Date operatetime) {
        this.operatetime = operatetime;
    }

    public String getOperateip() {
        return operateip;
    }

    public void setOperateip(String operateip) {
        this.operateip = operateip == null ? null : operateip.trim();
    }
}