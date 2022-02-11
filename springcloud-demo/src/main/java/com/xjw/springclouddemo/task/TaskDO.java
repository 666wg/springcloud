package com.xjw.springclouddemo.task;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Desc: 任务实体类
 * @Date: 2022/1/13 14:44
 */
@Data
@TableName("task")
public class TaskDO implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

    /** 任务类型 */
    @TableField("task_type")
    private String taskType;

    /** 任务 参数 */
    @TableField("param")
    private String param;

    /** 状态 */
    @TableField("state")
    private Integer state;

    @TableField("retry_num")
    private Integer retryNum;

    private Integer lockNum;

    /** 创建时间 */
    @TableField("create_time")
    private Date createTime;

    /** 更新时间 */
    @TableField("update_time")
    private Date updateTime;

//    private String detail;
//    private String transactionId;
//    private Integer actionType;

}
