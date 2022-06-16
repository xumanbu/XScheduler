package org.example.executor;

import lombok.Data;
import org.example.dagmanger.Dag;

import java.util.Date;

@Data
public class DagExecution {
    private Dag dag;
    private String executionId;
    private String status;
    /**
     * 计划执行时间
     */
    private Date scheduleTime;
    private Date exeStartTime;
    private Date exeEndTime;
}
