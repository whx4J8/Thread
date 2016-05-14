package com.mutithread.demo1;

import java.util.Random;

/**
 * Created by wanghongxing on 16/5/14.
 */
public class ServerThread extends Thread {

    private Random random;
    private final RequestQueue requestQueue;

    public ServerThread(RequestQueue requestQueue, String name, long seed) {
        super(name);
        this.random = new Random(seed);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {

        int requestNum = 10000;
        for (int i = 0; i < requestNum; i++) {
            Request request = requestQueue.getRequest();
            log(Thread.currentThread().getName() + " handles " + request);
            doSomeThing();
        }

    }

    private void log(String log) {
        System.out.println(log);
    }

    private void doSomeThing() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
