package com.tal.pojo;

import java.util.Date;

public class SysRole {
    private Integer rid;

    private String name;

    private Integer type;

    private Integer status;

    private String remark;

    private String operator;

    private Date operatetime;

    private String operateip;

    public SysRole(Integer rid, String name, Integer type, Integer status, String remark, String operator, Date operatetime, String operateip) {
        this.rid = rid;
        this.name = name;
        this.type = type;
        this.status = status;
        this.remark = remark;
        this.operator = operator;
        this.operatetime = operatetime;
        this.operateip = operateip;
    }

    public SysRole() {
        super();
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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