package org.example.executor.notice;

import org.example.executor.OperatorTask;

public interface Notice {

    /**
     * notification to owner and backup owner
     * @param owner
     * @param backupOwner
     * @param operatorTask
     */
    void message(OperatorTask operatorTask);

}
