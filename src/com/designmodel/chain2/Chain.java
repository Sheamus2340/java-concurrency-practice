package com.designmodel.chain2;

import java.util.List;

/**
 * 处理请求的入口
 * Created by Sheamus on 2018/6/26.
 */
public class Chain {

    private List<Ratify> ratifys;//所有请求的审批者
    private Request request;//请求
    private int index;//用于标识传递的链标记

    public List<Ratify> getRatifys() {
        return ratifys;
    }

    public void setRatifys(List<Ratify> ratifys) {
        this.ratifys = ratifys;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Chain(List<Ratify> ratifys, Request request, int index) {
        this.ratifys = ratifys;
        this.request = request;
        this.index = index;
    }

    public void addRatify(Ratify ratify) {
        ratifys.add(ratify);
    }

    void proceed() {
        String reult = ratifys.get(index++).deal(this);
        System.out.println(reult);
    }

}
