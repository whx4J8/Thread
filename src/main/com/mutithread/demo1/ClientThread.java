package com.mutithread.demo1;

import java.util.Random;

/**
 * Created by wanghongxing on 16/5/14.
 */
public class ClientThread extends Thread {

    private Random random;
    private final RequestQueue requestQueue;

    public ClientThread(RequestQueue requestQueue, String name, long seed) {
        super(name);
        this.random = new Random(seed);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {

        int requestNum = 10000;
        for (int i = 0; i < requestNum; i++){
            Request request = new Request("No." + i);
            log(Thread.currentThread().getName() + " requests " + request);
            requestQueue.putRequest(request);
            doSomeThing();
        }

    }

    private void log(String log){
        System.out.println(log);
    }

    private void doSomeThing(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
