package com.jayne.thinkinginjava.two;

/**
 * Created by Jayne on 2019/1/6.
 */
public class SerialNumberGenerator {

    private static volatile int serialNumber = 0;
    public static int nextSerialNumber(){
        return serialNumber++;
    }
}
