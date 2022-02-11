package com.xjw.springclouddemo.task.process;

import com.alibaba.fastjson.JSON;
import com.xjw.springclouddemo.task.TaskDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Desc: 任务处理
 * @Date: 2022/1/13 14:55
 */
@Component
@Slf4j
public class Task1Process implements TaskProcess {


    /**
     * Task1 任务处理
     */
    @Override
    public boolean process(TaskDO task) {
        log.info("Task1Process 开始执行了....." + JSON.toJSONString(task));
        return true;
    }


}
