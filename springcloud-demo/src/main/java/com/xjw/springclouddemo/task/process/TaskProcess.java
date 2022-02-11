package com.xjw.springclouddemo.task.process;

import com.xjw.springclouddemo.task.TaskDO;
import org.springframework.stereotype.Component;

/**
 * @Desc: 任务处理
 * @Date: 2022/1/13 14:55
 */
@Component
public interface TaskProcess {


    /**
     * Task 任务处理
     */
    public boolean process(TaskDO task);


}
