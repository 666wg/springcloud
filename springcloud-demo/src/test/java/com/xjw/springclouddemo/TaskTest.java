package com.xjw.springclouddemo;

import com.xjw.springclouddemo.task.TaskManager;
import com.xjw.springclouddemo.task.TaskDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTest {


    @Autowired
    private TaskManager taskManager;

    @Test
    public void testAsyncTask() {
        log.info("任务测试start ==========");
        for (int i = 0; i < 110; i++) {
            TaskDO taskDO = new TaskDO();
            taskDO.setId(i);
            taskDO.setTaskType("task"+ ((i%2==1)?1:2) );
            taskManager.addToThreadPool(taskDO);
        }
        log.info("任务测试end ==========");
    }

}
