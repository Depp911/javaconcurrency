package com.jayne.thinkinginjava.one;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程
 *
 * Created by Jayne on 2019/1/5.
 */
public class SimpleDaemons implements Runnable {

    public void run() {
        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }catch (InterruptedException e){
                System.out.println("interrupted");
            }
        }
    }

    public static void main(String[] args) throws Exception{
        for(int i = 0; i < 10; i++){
            Thread thread = new Thread(new SimpleDaemons());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(220);
    }
}
