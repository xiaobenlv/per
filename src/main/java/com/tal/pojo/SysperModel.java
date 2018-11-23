package com.tal.pojo;

import java.util.Date;

public class SysperModel {
    private Integer pmid;

    private String name;

    private Integer parentid;

    private String level;

    private Integer seq;

    private Integer status;

    private String remark;

    private String operator;

    private Date operatetime;

    private String operateip;

    public SysperModel(Integer pmid, String name, Integer parentid, String level, Integer seq, Integer status, String remark, String operator, Date operatetime, String operateip) {
        this.pmid = pmid;
        this.name = name;
        this.parentid = parentid;
        this.level = level;
        this.seq = seq;
        this.status = status;
        this.remark = remark;
        this.operator = operator;
        this.operatetime = operatetime;
        this.operateip = operateip;
    }

    public SysperModel() {
        super();
    }

    public Integer getPmid() {
        return pmid;
    }

    public void setPmid(Integer pmid) {
        this.pmid = pmid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
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