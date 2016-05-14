package com.mutithread.demo1;


/**
 * Created by wanghongxing on 16/5/14.
 */
public class Main {

    public static void main(String[] args){
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue,"client thread",2323423l).start();
        new ServerThread(requestQueue,"server thread-demo1",9292822l).start();
        new ServerThread(requestQueue,"server thread-2",9292822l).start();
        new ServerThread(requestQueue,"server thread-3",9292822l).start();
        new ServerThread(requestQueue,"server thread-4",9292822l).start();
        new ServerThread(requestQueue,"server thread-5",9292822l).start();
    }
}
