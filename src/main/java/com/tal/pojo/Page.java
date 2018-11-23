package com.tal.pojo;

import java.util.List;

public class Page {
    private int pagenow=1;


    private int pagesize=10;
//  查询 得出
    private int totalcount;
//  计算 得出 total/pagesize 以及考虑是否加1
    private int totalpagecount;

//  计算得出从哪开始查询，这个参数要给mapper
    private int startpagecolumn;

    private List<Page> pageList;

    public List<Page> getPageList() {
        return pageList;
    }

    public void setPageList(List<Page> pageList) {
        this.pageList = pageList;
    }

    public Page(int pagenow, int totalpagecount){

    }

    public int getPagenow() {
        return pagenow;
    }

    public void setPagenow(int pagenow) {
        this.pagenow = pagenow;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }
    public int getStartpagecolumn(){
        return (pagenow-1)*pagesize;

    }
    public void setStartpagecolumn(int startpagecolumn){
        this.startpagecolumn=startpagecolumn;

    }
    public int getTotalpagecount(){
        totalpagecount=getTotalcount()/getPagesize();
        return (totalcount%pagesize==0)?totalpagecount:totalpagecount+1;
    }
    public void setTotalpagecount(int totalpagecount){
        this.totalpagecount=totalpagecount;
    }
}
