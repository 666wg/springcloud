package com.xjw.springcloudclient.controller;

import com.xjw.springcloudclient.entity.Person;
import com.xjw.springcloudclient.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
@RefreshScope
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/get")
    public Object get() {
        log.info("===== Controller层/get方法 =====");
        List<Person> list = personService.list();
        return list;
    }
}
