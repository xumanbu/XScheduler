package org.example.executor;

import lombok.Data;
import org.example.dagmanger.Dag;
import org.example.dagmanger.Operator;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Data
public class DagExecution {
    private Dag dag;
    private String executionId;
    /**
     * waiting,skipped,scheduled,running,cancel
     */
    private String status = "waiting";
    /**
     * 计划执行时间
     */
    private Date scheduleTime;
    private Date exeStartTime;
    private Date exeEndTime;


    List<OperatorTask> operatorTaskList;

    public DagExecution(Dag dag) {
        this.dag = dag;
        this.operatorTaskList = buildOperatorTaskList();
        // init field from dag
    }

    private LinkedList<OperatorTask> buildOperatorTaskList(){
        LinkedList<OperatorTask> operatorTaskList = new LinkedList<>();
        // BFS遍历Operator进行任务执行
        LinkedList<Operator> queue = new LinkedList<>();
        queue.add(dag.getStartOperator());
        while(queue.size()!=0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Operator operator = queue.poll();
                operatorTaskList.add(new OperatorTask(operator));
                Iterator<Operator> iter = operator.iter();
                while (iter.hasNext()) {
                    queue.add(iter.next());
                }
            }
        }
        return operatorTaskList;
    }



    public OperatorTask getNext(){
        if(operatorTaskList.iterator().hasNext()){
            return operatorTaskList.iterator().next();
        }
        return null;
    }
}
