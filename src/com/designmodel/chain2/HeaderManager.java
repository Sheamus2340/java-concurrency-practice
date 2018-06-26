package com.designmodel.chain2;

/**
 * Created by Sheamus on 2018/6/26.
 */
public class HeaderManager implements Ratify {
    @Override
    public String deal(Chain chain) {
        Request request = chain.getRequest();
        if(request.getDays() >= 5 && request.getDays() < 8) {
            return "Manager 批准你请假";
        } else {
            return "不用请假了";
        }
    }
}
