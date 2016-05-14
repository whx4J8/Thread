package com.mutithread.demo1;

import java.util.LinkedList;

/**
 * Created by wanghongxing on 16/5/14.
 */
public class RequestQueue {

    private final LinkedList<Request> queue = new LinkedList();

    public synchronized Request getRequest(){
        while(queue.size() <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.removeFirst();
    }

    public synchronized void putRequest(Request request){
        queue.addLast(request);
        notifyAll();
    }

}

class Request{

    private final String value;

    Request(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Request{" +
                "value='" + value + '\'' +
                '}';
    }
}
