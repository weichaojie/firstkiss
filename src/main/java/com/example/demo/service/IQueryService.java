package com.example.demo.service;

import com.example.demo.entity.ExpandData;

import java.util.List;

public interface IQueryService {

    public List<ExpandData> getAllList();

    public int getValueByName(String name);

    public ExpandData getValueById(int id);

}
