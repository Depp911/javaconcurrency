package com.jayne.thinkinginjava.two;

/**
 * Created by Jayne on 2019/1/6.
 */
public abstract class IntGenerator {

    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel(){
        canceled = true;
    }

    public boolean isCanceled(){
        return canceled;
    }
}
