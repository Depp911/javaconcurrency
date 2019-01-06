package com.jayne.thinkinginjava.one.test;

import com.jayne.thinkinginjava.one.LiftOff;

/**
 * Created by Jayne on 2019/1/4.
 */
public class BasicThread {

    public static void main(String[] args) {
        Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("waiting for LiftOff");
    }
}
