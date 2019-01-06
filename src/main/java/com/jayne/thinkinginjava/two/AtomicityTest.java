package com.jayne.thinkinginjava.two;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jayne on 2019/1/6.
 */
public class AtomicityTest implements Runnable {

    private int value;

    public int get(){
        return value;
    }

    public synchronized void evenIncrement(){
        value++;
        Thread.yield();
        value++;
    }

    public void run() {
        while (true){
            evenIncrement();
        }
    }

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicityTest atomicityTest = new AtomicityTest();
        executorService.execute(atomicityTest);
        TimeUnit.SECONDS.sleep(1);
        while (true){
            int val = atomicityTest.get();
            if(val % 2 != 0){
                System.out.println(val + " not even");
                System.exit(0);
            }
        }
    }
}
