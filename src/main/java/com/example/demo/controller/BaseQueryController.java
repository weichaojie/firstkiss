package com.example.demo.controller;

import com.example.demo.entity.ExpandData;
import com.example.demo.service.IQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// https://blog.csdn.net/weixin_44337445/article/details/122033740

@RestController
public class BaseQueryController {

    @Autowired
    IQueryService queryService;

    @RequestMapping(value = "/getalllist")
    private List<ExpandData> getAllList() {
        return queryService.getAllList();
    }

    @RequestMapping(value = "/getvalue/{name}")
    private int getValueByName(@PathVariable("name") String name) {
        return queryService.getValueByName(name);
    }

    @RequestMapping(value = "/getdata/{id}")
    private ExpandData getValueByName(@PathVariable("id") int id) {
        return queryService.getValueById(id);
    }

    @RequestMapping(value = "/adddata/{name}/{value}")
    private HttpStatus addData(@PathVariable("name") String name, @PathVariable("value") int value) {
        return queryService.addData(name, value);
    }

}
