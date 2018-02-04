package com.easy.simple.pool;

import java.util.List;

/**
 * @author wangqing 
 */

public class RpcLogTest {

    public static void main(String[] args) {
        RpcLogTaskProducer rpcLogTaskProducer = new RpcLogTaskProducer();
        rpcLogTaskProducer.producer();

        List<RpcLogTask> rpcLogTasks = rpcLogTaskProducer.getRpcLogTasks();

        RpcLogTaskConsumer rpcLogTaskConsumer = new RpcLogTaskConsumer();

        rpcLogTasks.forEach(rpcLogTaskConsumer::consumer);
    }

}
