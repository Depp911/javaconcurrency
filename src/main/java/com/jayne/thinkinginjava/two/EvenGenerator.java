package com.jayne.thinkinginjava.two;

/**
 * Created by Jayne on 2019/1/6.
 */
public class EvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
