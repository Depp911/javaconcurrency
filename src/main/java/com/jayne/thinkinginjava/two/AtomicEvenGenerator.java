package com.jayne.thinkinginjava.two;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Jayne on 2019/1/6.
 */
public class AtomicEvenGenerator extends EvenGenerator {

    private AtomicInteger value = new AtomicInteger(0);

    @Override
    public int next() {
        return value.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
