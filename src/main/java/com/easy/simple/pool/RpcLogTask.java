package com.easy.simple.pool;

import java.util.Random;

/**
 * @author wangqing 
 */

public class RpcLogTask implements Runnable {

    private final String taskName;

    private static final Random R = new Random();

    public RpcLogTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(R.nextInt(2222));
        } catch (InterruptedException e) {
        }
//        System.out.println("taskName=" + taskName);
    }

    public String getTaskName() {
        return taskName;
    }
}
