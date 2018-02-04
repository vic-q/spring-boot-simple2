package com.easy.simple.pool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangqing 
 */

public class RpcLogTaskProducer {

    private List<RpcLogTask> rpcLogTasks = new ArrayList<>(10000);

    public void producer() {
        for (int i = 0; i < 10000; i++) {
            rpcLogTasks.add(new RpcLogTask("RpcLogTask-" + i));
        }
    }

    public List<RpcLogTask> getRpcLogTasks() {
        return rpcLogTasks;
    }
}
