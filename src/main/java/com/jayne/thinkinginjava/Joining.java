package com.jayne.thinkinginjava;

import java.util.concurrent.TimeUnit;

/**
 * join()的使用
 *
 * Created by Jayne on 2019/1/5.
 */
class Sleeper extends Thread{

    private int duration;
    public Sleeper(String name, int duration){
        super(name);
        this.duration = duration;
        start();
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(duration);
        }catch (InterruptedException e){
            System.out.println(getName() + " was interrupted. isInterrupted():" + isInterrupted());
        }
        System.out.println(getName() + " has awakened");
    }
}

class Joiner extends Thread{
    Sleeper sleeper;
    public Joiner(String name, Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        }catch (InterruptedException e){
            System.out.println("interrupred");
        }
        System.out.println(getName() + " join completed");
    }
}

public class Joining {

    public static void main(String[] args) {
        Sleeper grumpy = new Sleeper("Grumpy", 1500),
                sleepy = new Sleeper("Sleepy", 1500);
        Joiner doc = new Joiner("Doc", grumpy),
                dopey = new Joiner("Dopey", sleepy);
        grumpy.interrupt();
    }
}
