package org.example.executor;

import lombok.Data;

@Data
public class ExecutorProperties {

    private Integer MAX_QUEUE_SIZE = 10;
    private Integer MAX_RUN_TASKS = 10;
}
