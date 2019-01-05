package com.jayne.thinkinginjava.test;

import com.jayne.thinkinginjava.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 初步使用Executor
 *
 * Created by Jayne on 2019/1/5.
 */
public class CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++){
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
