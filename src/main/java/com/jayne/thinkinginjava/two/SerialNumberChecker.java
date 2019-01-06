package com.jayne.thinkinginjava.two;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Jayne on 2019/1/6.
 */
class CircularSet{
    private int[] array;
    private int len;
    private int index = 0;

    public CircularSet(int size){
        array = new int[size];
        len = size;
        for(int i = 0; i < size; i++){
            array[i] = -1;
        }
    }

    public synchronized void add(int val){
        array[index] = val;
        index = ++index % len;
    }

    public synchronized boolean contains(int val){
        for(int i = 0; i < len; i++){
            if(array[i] == val){
                return true;
            }
        }
        return false;
    }
}

public class SerialNumberChecker {

    private static final int SIZE = 10;
    private static CircularSet circularSet = new CircularSet(1000);
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    static class SerialChecker implements Runnable{
        public void run() {
            while (true){
                int value = SerialNumberGenerator.nextSerialNumber();
                if(circularSet.contains(value)){
                    System.out.println("Duplicate: " + value);
                    System.exit(0);
                }
                circularSet.add(value);
            }
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < SIZE; i++){
            executorService.execute(new SerialChecker());
        }
    }
}
