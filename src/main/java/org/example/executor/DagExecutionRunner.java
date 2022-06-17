package org.example.executor;

import java.util.concurrent.ArrayBlockingQueue;
public abstract class DagExecutionRunner {

    ExecutorProperties executorProperties;

    Integer currentRunningTasks = 0;

    OperatorTaskRunner operatorTaskRunner;

    ArrayBlockingQueue<DagExecution> arrayBlockingQueue =  new ArrayBlockingQueue(executorProperties.getMAX_QUEUE_SIZE());

    DagExecutionStatus run(DagExecution dagExecution){
       if(currentRunningTasks< executorProperties.getMAX_RUN_TASKS()){
           OperatorTask operatorTask = dagExecution.getNext();
           OperatorTaskStatus taskStatus = operatorTaskRunner.run(operatorTask);

           if(taskStatus!=OperatorTaskStatus.SUCCESS){
               // @TODO 重试机制
               return DagExecutionStatus.RESCHEDULE;
           }else{

           }
       }
       return DagExecutionStatus.SUCCESS;
    }




}
