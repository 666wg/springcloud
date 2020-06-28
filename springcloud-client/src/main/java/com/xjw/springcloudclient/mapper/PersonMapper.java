package com.xjw.springcloudclient.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xjw.springcloudclient.entity.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper extends BaseMapper<Person>{
    int deleteByPrimaryKey(Integer id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
}