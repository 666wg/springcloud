package com.xjw.springclouddemo.task.service.impl;

import com.xjw.springclouddemo.task.TaskDO;
import com.xjw.springclouddemo.task.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Override
    public List<TaskDO> findListOfUnPush(Date currentTime, int min) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        // todo 删除，移到备份表
        return true;
    }
}
