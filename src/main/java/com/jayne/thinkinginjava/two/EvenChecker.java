package com.jayne.thinkinginjava.two;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Jayne on 2019/1/6.
 */
public class EvenChecker implements Runnable {

    private IntGenerator intGenerator;
    private final int id;

    public EvenChecker(IntGenerator intGenerator, int id){
        this.intGenerator = intGenerator;
        this.id = id;
    }

    public void run() {
        while (!intGenerator.isCanceled()){
            int value = intGenerator.next();
            if(value % 2 != 0){
                System.out.println(value + " not even!");
                intGenerator.cancel();
            }
        }
    }

    public static void test(IntGenerator intGenerator, int count){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < count; i++){
            executorService.execute(new EvenChecker(intGenerator, i));
        }
        executorService.shutdown();
    }

    public static void test(IntGenerator intGenerator){
        test(intGenerator, 10);
    }
}
