package com.tal.pojo;

import java.util.Date;

public class SysPer {
    private Integer pid;

    private String name;

    private String code;

    private Integer aclmodId;

    private String url;

    private Integer type;

    private Integer status;

    private Integer seq;

    private String operator;

    private Date operatetime;

    private String operateip;

    public SysPer(Integer pid, String name, String code, Integer aclmodId, String url, Integer type, Integer status, Integer seq, String operator, Date operatetime, String operateip) {
        this.pid = pid;
        this.name = name;
        this.code = code;
        this.aclmodId = aclmodId;
        this.url = url;
        this.type = type;
        this.status = status;
        this.seq = seq;
        this.operator = operator;
        this.operatetime = operatetime;
        this.operateip = operateip;
    }

    public SysPer() {
        super();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getAclmodId() {
        return aclmodId;
    }

    public void setAclmodId(Integer aclmodId) {
        this.aclmodId = aclmodId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
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