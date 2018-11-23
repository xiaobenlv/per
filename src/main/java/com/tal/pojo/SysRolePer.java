package com.tal.pojo;

import java.util.Date;

public class SysRolePer {
    private Integer id;

    private Integer pid;

    private Integer rid;

    private String operator;

    private Date operatetime;

    private String operateip;

    public SysRolePer(Integer id, Integer pid, Integer rid, String operator, Date operatetime, String operateip) {
        this.id = id;
        this.pid = pid;
        this.rid = rid;
        this.operator = operator;
        this.operatetime = operatetime;
        this.operateip = operateip;
    }

    public SysRolePer() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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