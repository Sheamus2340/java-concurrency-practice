package com.designmodel.chain2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sheamus on 2018/6/26.
 */
public class Main {
    public static void main(String[] args) {
        List<Ratify> ratifys = new ArrayList<>();
        ratifys.add(new GroupLeader());
        ratifys.add(new Manager());
        ratifys.add(new HeaderManager());

        Request request = new Request("张三",5,"事假");

        Chain chain = new Chain(ratifys,request,0);
        chain.proceed();
    }
}
