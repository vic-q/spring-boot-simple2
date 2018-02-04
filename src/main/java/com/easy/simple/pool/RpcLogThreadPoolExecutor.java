package com.easy.simple.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wangqing
 */

public class RpcLogThreadPoolExecutor extends ThreadPoolExecutor {

    private final ThreadLocal<Long> timed = new ThreadLocal<>();


    public RpcLogThreadPoolExecutor(int corePoolSize,
                                    int maximumPoolSize,
                                    long keepAliveTime,
                                    TimeUnit unit,
                                    BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public RpcLogThreadPoolExecutor(int corePoolSize,
                                    int maximumPoolSize,
                                    long keepAliveTime,
                                    TimeUnit unit,
                                    BlockingQueue<Runnable> workQueue,
                                    ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public RpcLogThreadPoolExecutor(int corePoolSize,
                                    int maximumPoolSize,
                                    long keepAliveTime,
                                    TimeUnit unit,
                                    BlockingQueue<Runnable> workQueue,
                                    RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public RpcLogThreadPoolExecutor(int corePoolSize,
                                    int maximumPoolSize,
                                    long keepAliveTime,
                                    TimeUnit unit,
                                    BlockingQueue<Runnable> workQueue,
                                    ThreadFactory threadFactory,
                                    RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);

    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        timed.set(System.currentTimeMillis());
        System.out.println("ThreadName=" + Thread.currentThread().getName());
    }


    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        //总任务数量
        long taskCount = getTaskCount();
        //已执行完的任务数量
        long completedTaskCount = getCompletedTaskCount();
        //剩余任务数量
        long restTaskCount = taskCount - completedTaskCount;
        System.out.println(String.format("总任务数：%s，已完成任务数：%s，剩余任务数：%s", taskCount, completedTaskCount, restTaskCount));

        long elasped = System.currentTimeMillis() - timed.get();
        System.out.println(String.format("任务执行耗时：%s[ms]", elasped));

        timed.remove();
    }
}
