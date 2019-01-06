package com.jayne.thinkinginjava.one;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 使用有返回值的并发任务接口Callable
 *
 * Created by Jayne on 2019/1/5.
 */
public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id){
        this.id = id;
    }

    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<Future<String>>();
        for(int i = 0; i < 10; i++){
            results.add(executorService.submit(new TaskWithResult(i)));
        }
        for(Future future : results){
            try {
                System.out.println(future.get());
            }catch (InterruptedException e){
                System.out.println(e);
            }catch (ExecutionException e){
                System.out.println(e);
            }finally {
                executorService.shutdown();
            }

        }
    }
}
