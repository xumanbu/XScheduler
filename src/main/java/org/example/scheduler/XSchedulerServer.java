package org.example.scheduler;

import org.example.dagmanger.Dag;
import org.example.executor.DagExecution;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class XSchedulerServer {
    public void start(){
        initialSchedule();
    }

    public abstract void stop();

    /**
     * 从数据库初始化定时任务到本地schedule
     */
    public  void initialSchedule(){
        List<Dag> dagList = null;// getDagList from db dag detail table
        dagList.forEach(dag->{
            ScheduledExecutorService scheduledExecutorService = getScheduledExecutorService();
            // @TODO 参数设计根据需求，这里只是表达初始化本地schedule action
            scheduledExecutorService.scheduleAtFixedRate(() -> {
                // DagExecution from Dag
                DagExecution dagExecution = getDagExecution();
                runJob(dagExecution);
            },1,dag.getInterval(), TimeUnit.SECONDS);
        });

    }


    private DagExecution getDagExecution(){
        return null;
    }

    protected abstract SchedulerProperties getSchedulerProperties();

    protected abstract ScheduledExecutorService getScheduledExecutorService();

    public abstract void runJob(DagExecution dagExecution);

}
