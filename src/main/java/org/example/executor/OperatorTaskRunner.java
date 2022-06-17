package org.example.executor;

import org.example.executor.notice.Notice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static org.example.executor.OperatorTaskStatus.*;

public class OperatorTaskRunner {

    ExecutorService executorService;

    Notice notice;

    /**
     * 这个方法是真正执行operatorTask的方法
     * @param operatorTask
     * @returnØ
     */
    OperatorTaskStatus run(OperatorTask operatorTask){
        Future<OperatorTaskStatus> submit = executorService.submit(operatorTask);
        try {
            OperatorTaskStatus o = submit.get();

            switch (o) {
                case SUCCESS:
                    // do something
                    break;
                case FAILED:
                    // 通知
                    notice.message(operatorTask);
                    break;
                default:
                    break;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        return null;
    }


}
