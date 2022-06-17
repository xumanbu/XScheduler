package org.example.executor;

import org.example.dagmanger.Operator;

import java.util.concurrent.Callable;

public class OperatorTask implements Callable {

    private Operator operator;

    public OperatorTask(Operator operator) {
        this.operator  = operator;
    }

    @Override
    public OperatorTaskStatus call() throws Exception {
        return null;
    }
}
