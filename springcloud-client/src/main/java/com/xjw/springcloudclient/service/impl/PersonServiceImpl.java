package com.xjw.springcloudclient.service.impl;

import com.xjw.springcloudclient.mapper.PersonMapper;
import com.xjw.springcloudclient.entity.Person;
import com.xjw.springcloudclient.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {
}
