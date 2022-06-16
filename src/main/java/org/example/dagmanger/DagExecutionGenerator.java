package org.example.dagmanger;

import org.example.executor.DagExecution;

import java.util.List;

public interface DagExecutionGenerator {

    /**
     * 根据DAG生成DagExecution,支持静态生成或者实时生成
     */
    List<DagExecution> generate(Dag dag,boolean isDynamic);

}
