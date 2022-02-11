package com.xjw.springclouddemo.task;

import com.xjw.springclouddemo.task.service.TaskService;
import com.xjw.springclouddemo.task.thread.ThreadPoolConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 这是一个监控进程，通过定期扫描未完成任务队列实现任务重试机制。
 * <p>
 * 整个事物处理流程如下：
 * 1. 记录消息到任务表
 * 2. 通过内存队列异步发送消息
 * 3. 如果发送消息成功， 在任务表里面的记录将被删除。
 * 4. 如果异常（停机/断网），任务表里面将会记录未完成记录
 * 5. 后台重试任务将定时查询未完成任务并重试执行，直到所有任务都被执行
 * <p>
 * 重试任务是单线程， 异步执行任务是采用线程池 执行任务。
 */
@Component
@Slf4j
public class DbToTaskSchedule {

    @Resource(name = "taskThreadPoolExecutor")
    private ThreadPoolExecutor threadPoolExecutor;
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskManager taskManager;

    /**
     * @Desc: 将数据库中 需要执行的任务 添加到线程池
     * @Date: 2022/1/13 14:58
     */
    @Scheduled(cron = "0/1 * *  * * ? ")
    public void addDbToTask() {
        try {
            log.info("==============定时任务 db任务开始处理==============");
            // fixme 并发判断不准确，不过没事 taskManager.addToThreadPool 有锁
            if (threadPoolExecutor.getQueue().size() == ThreadPoolConfig.queueCapacity) {
                log.info("==============队列超过最大限制，定时任务结束==============");
                return;
            }
            Date currentTime = new Date();
            //查询3分钟前创建的任务
            List<TaskDO> taskList = taskService.findListOfUnPush(currentTime, -3);
            if (!CollectionUtils.isEmpty(taskList)) {
                for (TaskDO taskDO : taskList) {
                    //推送次数
                    int num = taskDO.getRetryNum() == null ? 0 : taskDO.getRetryNum();
                    Integer id = taskDO.getId();
                    Date createTime = taskDO.getCreateTime();
                    //创建时间和当前时间间隔
                    int intervalMinite = getIntervalMinutes(createTime, currentTime);
                    boolean isPush = isPush(num, intervalMinite, id);
                    if (isPush) {
                        //将推送任务加入到任务队列
                        taskManager.addToThreadPool(taskDO);
                    }
                }
            }
        } catch (Exception e) {
            log.error("异常：", e);
        }
    }

    /**
     * @Desc: 通知频率为 15s/15s/30s/3m/10m/20m/30m/30m/30m/60m/3h/3h/3h/6h/6h
     * @Date: 2022/1/13 17:41
     */
    private boolean isPush(int num, int intervalMinite, Integer id) {
        boolean isPush = false;
        if (num <= 1) {
            isPush = true;
        } else if (num == 2) {
            if (intervalMinite >= 10) {
                isPush = true;
            }
        } else if (num == 3) {
            if (intervalMinite >= 20) {
                isPush = true;
            }
        } else if (num == 4) {
            if (intervalMinite >= 30) {
                isPush = true;
            }
        } else if (num == 5) {
            if (intervalMinite >= 40) {
                isPush = true;
            }
        } else if (num >= 6) {
            if (intervalMinite >= 50) {
                isPush = true;
                //如果超过 3*24*60分钟 ，视为废弃的推送任务，删除推送任务记录
                if (intervalMinite >= 3 * 24 * 60) {
                    taskService.deleteById(id);
                    isPush = false;
                }
            }
        }
        return isPush;
    }

    /**
     * 获取两个日期的间隔分数
     *
     * @param smallDate 小日期
     * @param bigDate   大日期
     */
    public static int getIntervalMinutes(Date smallDate, Date bigDate) {
        Calendar d1 = new GregorianCalendar();
        d1.setTime(smallDate);
        Calendar d2 = new GregorianCalendar();
        d2.setTime(bigDate);
        long ei = d2.getTimeInMillis() - d1.getTimeInMillis();
        int dd = (int) (ei / (1000 * 60));
        if (dd < 1) dd = 1;
        return dd;
    }

}
