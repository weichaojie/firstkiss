package com.example.demo.service;

import com.example.demo.entity.ExpandData;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface IQueryService {

    public List<ExpandData> getAllList();

    public int getValueByName(String name);

    public ExpandData getValueById(int id);

    public HttpStatus addData(String name, int value);

}
