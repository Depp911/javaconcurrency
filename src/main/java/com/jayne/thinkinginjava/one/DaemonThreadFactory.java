package com.jayne.thinkinginjava.one;

import java.util.concurrent.ThreadFactory;

/**
 * 后台线程工厂
 *
 * Created by Jayne on 2019/1/5.
 */
public class DaemonThreadFactory implements ThreadFactory {

    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
