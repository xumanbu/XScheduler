package org.example.dagmanger;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
public class Dag {
    private Long dagId;
    private String name;
    private Date startTime;
    private Date endTime;
    private String cronScript;
    private StartOperator startOperator = new StartOperator();

    /**
     * add operator to dag
     * @param operator
     * @return
     */
    private boolean addOperator(Operator operator){
        startOperator.operatorList.add(operator);
        if(checkDag()){
            startOperator.operatorList.removeLast();
            return false;
        }
        return true;
    }

    private boolean checkDag(){
        // dfs 检查图是否存在环
        return true;
    }


    public static class StartOperator{
        LinkedList<Operator> operatorList = new LinkedList<>();
    }


}


