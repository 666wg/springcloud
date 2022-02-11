package com.xjw.springclouddemo.task.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class ThreadPoolConfig {

    public static int corePoolSize = 2;
    public static int maxPoolSize = 4;
    public static int keepAliveSeconds = 60;
    public static int queueCapacity = 100;

    /**
     * @Desc: JDK线程池
     * @Date: 2022/1/13 14:14
     */
    @Bean("taskThreadPoolExecutor")
    ThreadPoolExecutor getThreadPoolExecutor() {
        //ArrayBlockingQueue：基于数组的先进先出队列，此队列创建时必须指定大小；
        //LinkedBlockingQueue：基于链表的先进先出队列，如果创建时没有指定此队列大小，则默认为Integer.MAX_VALUE；
        //SynchronousQueue：这个队列比较特殊，它不会保存提交的任务，而是将直接新建一个线程来执行新来的任务。

        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(
                        corePoolSize,
                        maxPoolSize,
                        keepAliveSeconds,
                        TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(queueCapacity),
                        Executors.defaultThreadFactory());
        return executor;
    }

    /**
     * @Desc: spring线程池
     * @Date: 2022/1/13 14:14
     */
    @Bean("taskThreadPoolTaskExecutor")
    ThreadPoolTaskExecutor getThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setQueueCapacity(queueCapacity);
        return executor;
    }

}
