package com.xjw.springclouddemo.task.service;

import com.xjw.springclouddemo.task.TaskDO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface TaskService {

    public List<TaskDO> findListOfUnPush(Date currentTime, int min);

    public boolean deleteById(Integer id);
}
