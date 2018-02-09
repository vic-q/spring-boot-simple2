package com.easy.simple.pool.scheduled;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangqing
 */

public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(1);
        for (int i = 0; i < 100; i++) {
            pool.scheduleWithFixedDelay(new Task(), 5, 5, TimeUnit.SECONDS);
            pool.scheduleWithFixedDelay(new Task2(), 5, 5, TimeUnit.SECONDS);
        }
        System.out.println("queenSize=" + pool.getQueue().size());
    }

    private static class Task implements Runnable {
        private static AtomicInteger number = new AtomicInteger(0);

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "--task exec..." + number.getAndIncrement() + ", " + new Date());
        }
    }

    private static class Task2 implements Runnable {
        private static AtomicInteger number = new AtomicInteger(0);

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "--task exec..." + number.getAndIncrement() + ", " + new Date());
        }
    }

}
