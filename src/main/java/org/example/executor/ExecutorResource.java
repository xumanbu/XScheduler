package org.example.executor;


import javax.annotation.Resource;

@Resource
public class ExecutorResource {
    DagExecutionRunner dagExecutionRunner;

    /**
     * 执行一个dagExecution任务
     * @param dagExecution
     * @return
     */
    public String acceptDagExecutionJob(DagExecution dagExecution){
        // checkQueue
        dagExecutionRunner.run(dagExecution);
        return null;
    }

}
