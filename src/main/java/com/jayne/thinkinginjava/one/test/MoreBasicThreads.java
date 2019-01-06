package com.jayne.thinkinginjava.one.test;

import com.jayne.thinkinginjava.one.LiftOff;

/**
 * Created by Jayne on 2019/1/4.
 */
public class MoreBasicThreads {

    public static void main(String[] args) {
        for(int i = 0; i < 5; i++){
            new Thread(new LiftOff()).start();
        }
        System.out.println("waiting for LiftOff");
    }
}
