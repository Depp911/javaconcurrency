package com.jayne.thinkinginjava.one;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 主线程无法捕获其他线程的异常
 *
 * Created by Jayne on 2019/1/5.
 */
public class ExceptionThread implements Runnable {
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ExceptionThread());

        try{
            executorService.execute(new ExceptionThread());
        }catch (Exception e){
            System.out.println("exception caught");
        }
    }
}
