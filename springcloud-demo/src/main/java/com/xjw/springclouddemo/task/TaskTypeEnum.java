package com.xjw.springclouddemo.task;

import lombok.Getter;

@Getter
public enum TaskTypeEnum {

    TASK_TYPE_1("task1","任务类型1")
    ;



    private String code;
    private String desc;

    TaskTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
