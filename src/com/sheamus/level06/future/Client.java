package com.sheamus.level06.future;

/**
 * Created by Sheamus on 2018/6/15.
 */
public class Client {
    public Data request(final String queryStr) {
        final FutureData future = new FutureData();
        new Thread(){
            @Override
            public void run() {
                //RealData的构造很慢，所以单独启动一个线程
                RealData realData = new RealData(queryStr);
                future.setRealData(realData);
            }
        }.start();
        return future;
    }
}
