package com.jayne.thinkinginjava.two;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Jayne on 2019/1/6.
 */
public class AtomicIntegerTest implements Runnable {

    private AtomicInteger i = new AtomicInteger(0);
    public int getValue(){
        return i.intValue();
    }
    private void evenIncrement(){
        i.addAndGet(2);
    }

    public void run() {
        while (true){
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Aborting");
                System.exit(0);
            }
        }, 5000);
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
        executorService.execute(atomicIntegerTest);
        while (true){
            int val = atomicIntegerTest.getValue();
            if(val % 2 != 0){
                System.out.println(val + " not even");
                System.exit(0);
            }
        }
    }
}
