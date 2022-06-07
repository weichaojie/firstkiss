package com.example.demo.service;

import com.example.demo.config.RedisConfig;
import com.example.demo.entity.ExpandData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QueryServiceImpl implements IQueryService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public List<ExpandData> getAllList() {

        System.out.println("Entering QueryServiceImpl:getAllList......");

        List<ExpandData> list = new ArrayList<>();
        ExpandData data1 = new ExpandData();
        data1.setId(1);
        data1.setName("湖北");
        data1.setValue(102);
        list.add(data1);

        ExpandData data2 = new ExpandData();
        data2.setId(2);
        data2.setName("重庆");
        data2.setValue(97);
        list.add(data2);

        ExpandData data3 = new ExpandData();
        data3.setId(3);
        data3.setName("北京");
        data3.setValue(99);
        list.add(data3);

        ExpandData data4 = new ExpandData();
        data4.setId(4);
        data4.setName("上海");
        data4.setValue(98);
        list.add(data4);

        return list;
    }

    @Override
    public int getValueByName(String name) {
        System.out.println("Entering QueryServiceImpl:getValueByName;input is " + name);
        Random random = new Random();
        int value = random.nextInt();
        return value;
    }

    @Override
    public ExpandData getValueById(int id) {
        System.out.println("Entering QueryServiceImpl:getValueById;input is " + id);
        Random random = new Random();
        ExpandData data = new ExpandData();
        data.setId(id);
        data.setName("上海");
        data.setValue(random.nextInt());

        HashOperations ops = redisTemplate.opsForHash();
        ops.put("k1", "h1", "v100");
        Object obj = ops.get("k1","h1");
        System.out.println(obj);
        return data;
    }

}
