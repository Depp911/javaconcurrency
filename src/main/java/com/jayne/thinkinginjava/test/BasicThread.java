package com.jayne.thinkinginjava.test;

import com.jayne.thinkinginjava.LiftOff;

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
