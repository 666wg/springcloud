package com.xjw.springclouddemo.task.process;

import com.alibaba.fastjson.JSON;
import com.xjw.springclouddemo.task.TaskDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc: 任务处理
 * @Date: 2022/1/13 14:55
 */
@Component
@Slf4j
public class TaskProcessFactory {


    @Autowired
    private final Map<String, TaskProcess> taskProcessMap = new HashMap<>();

    /**
     * 任务处理 入口
     */
    public void process(TaskDO task) {
        log.info("TaskProcessFactory - process - 任务处理入口....."+ JSON.toJSONString(task));
        // todo 任务具体处理
        String taskType = task.getTaskType();
        TaskProcess taskProcess = taskProcessMap.get(taskType + "Process");
        boolean flag = taskProcess.process(task);
        if (flag) {
            // todo 更新db状态、重试次数
        } else {
            // todo 更新db重试次数
        }
    }


}
