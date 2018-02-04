package com.easy.simple.pool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wangqing 
 */

public class RpcLogTaskConsumer {

    private static final ThreadPoolExecutor executor =
            new RpcLogThreadPoolExecutor(5, 5, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(100), new RpcLogTaskRejectedExecutionHandler());

    public void consumer(Runnable r) {
        executor.execute(r);
    }

}
