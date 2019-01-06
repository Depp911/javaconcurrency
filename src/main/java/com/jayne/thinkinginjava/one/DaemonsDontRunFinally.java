package com.jayne.thinkinginjava.one;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程不会执行finally语句
 *
 * Created by Jayne on 2019/1/5.
 */
class ADaemon implements Runnable{
    public void run() {
        try {
            System.out.println("start");
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            System.out.println(e);
        }finally {
            System.out.println("finally");
        }
    }
}

public class DaemonsDontRunFinally {

    public static void main(String[] args) {
        Thread thread = new Thread(new ADaemon());
        thread.setDaemon(true);
        thread.start();
    }
}
