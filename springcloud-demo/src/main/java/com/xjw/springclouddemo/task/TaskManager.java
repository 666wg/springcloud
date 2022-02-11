package com.xjw.springclouddemo.task;

import com.alibaba.fastjson.JSON;
import com.xjw.springclouddemo.task.process.TaskProcessFactory;
import com.xjw.springclouddemo.task.thread.ThreadPoolConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@Component
public class TaskManager {

    @Resource(name = "taskThreadPoolExecutor")
    private ThreadPoolExecutor threadPoolExecutor;
    @Autowired
    private TaskProcessFactory taskProcessFactory;


    /**
     * @Desc: 添加任务到线程池
     * @Date: 2022/1/13 11:43
     */
    public synchronized void addToThreadPool(TaskDO taskDO) {
        //队列未满，入队
        int currentQueueSize = threadPoolExecutor.getQueue().size();
        log.info("当前队列大小 {}", currentQueueSize);
        // fixme 需要加锁synchronized在方法上
        if (currentQueueSize < ThreadPoolConfig.queueCapacity) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("addToThreadPool 加入线程池....." + JSON.toJSONString(taskDO));
                    taskProcessFactory.process(taskDO);
                }
            });
        } else {
            // todo 未入线程池，db标注
            log.warn("队列满了，加入失败 {}", JSON.toJSONString(taskDO));
        }
    }


}
