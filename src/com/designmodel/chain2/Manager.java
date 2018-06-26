package com.designmodel.chain2;

/**
 * Created by Sheamus on 2018/6/26.
 */
public class Manager implements Ratify {
    @Override
    public String deal(Chain chain) {
        Request request = chain.getRequest();
        if(request.getDays() >= 2 && request.getDays() < 5) {
            return "Manager 批准你请假";
        } else {
            chain.proceed();
        }
        return "Manager 批准你请假";
    }
}
