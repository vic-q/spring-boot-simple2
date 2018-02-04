package com.easy.simple.pool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wangqing 
 */

public class RpcLogTaskRejectedExecutionHandler implements RejectedExecutionHandler {


    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("RpcLogTask被拒绝，taskName=" + ((RpcLogTask) r).getTaskName());
    }
}
