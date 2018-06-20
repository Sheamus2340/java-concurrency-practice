package com.sheamus.level06.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Sheamus on 2018/6/15.
 */
public class NIOEchoServer {

    private void startServer() throws IOException {
        AbstractSelector selector = SelectorProvider.provider().openSelector();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        InetSocketAddress isa = new InetSocketAddress(8000);
        ssc.socket().bind(isa);

        SelectionKey acceptKey = ssc.register(selector, SelectionKey.OP_ACCEPT);

        for (;;) {
            selector.select();
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> i = readyKeys.iterator();
            long e = 0;
            while(i.hasNext()) {
                SelectionKey sk = (SelectionKey)i.next();
                i.remove();

                if(sk.isAcceptable()) {
//                    doAccept(sk);
                } else if(sk.isValid() && sk.isReadable()) {
//                    if() {
//
//                    }
                }



            }


        }
    }

}
