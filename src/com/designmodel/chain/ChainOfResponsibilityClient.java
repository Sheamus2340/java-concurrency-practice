package com.designmodel.chain;

import java.util.ArrayList;

/**
 * 责任链的客户端
 * Created by Sheamus on 2018/6/26.
 */
public class ChainOfResponsibilityClient {
    //保存审批的人员
    private ArrayList<Ratify> ratifies;

    public ChainOfResponsibilityClient() {
        ratifies = new ArrayList<>();
    }

    /**
     * 方法描述：为了展示“责任链模式”的真正的迷人之处（可扩展性），在这里构造该方法以便添加自定义的“责任人”
     *
     * @param ratify
     */
    public void addRatifys(Ratify ratify) {
        ratifies.add(ratify);
    }

    /**
     * 方法描述：执行请求
     *
     * @param request
     * @return
     */
    public Result execute(Request request) {
        ArrayList<Ratify> arrayList = new ArrayList<>();
        arrayList.addAll(ratifies);
        arrayList.add(new GroupLeader());
        arrayList.add(new Manager());
        arrayList.add(new DepartmentHeader());

        RealChain realChain = new RealChain(arrayList, request, 0);
        return realChain.proceed(request);
    }
}
