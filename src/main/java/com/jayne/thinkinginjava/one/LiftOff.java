package com.jayne.thinkinginjava.one;

import java.util.concurrent.TimeUnit;

/**
 * 定义一个简单的任务（实现Runnable的方式）
 *
 * Created by Jayne on 2019/1/4.
 */
public class LiftOff implements Runnable {

    protected int countDown = 10;

    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff(){}

    public LiftOff(int countDown){
        this.countDown = countDown;
    }

    @Override
    public String toString() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + "),";
    }

    public void run() {
        while (countDown-- > 0){
            try {
                System.out.print(this);
                TimeUnit.SECONDS.sleep(1);
                Thread.yield();
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
