package com.example.demo.service;

import com.example.demo.entity.ExpandData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
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
        int value = Integer.MAX_VALUE;
        System.out.println("Entering QueryServiceImpl:getValueByName;input is " + name);
        try {
            HashOperations ops = redisTemplate.opsForHash();
            Object obj = ops.get("k1", name);
            value = Integer.parseInt(obj.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            return value;
        }
    }

    @Override
    public ExpandData getValueById(int id) {
        System.out.println("Entering QueryServiceImpl:getValueById;input is " + id);
        ExpandData data = new ExpandData();
        data.setId(id);
        HashOperations ops = redisTemplate.opsForHash();
        Object obj = ops.get("k1", "h1");
        data.setName(obj.toString());
        data.setValue(Integer.valueOf(obj.toString()));
        System.out.println(obj);
        return data;
    }

    @Override
    public HttpStatus addData(String name, int value) {

//        BoundValueOperations boundOps = redisTemplate.boundValueOps(name);
//        boundOps.set(Integer.toString(value), value);

        HashOperations ops = redisTemplate.opsForHash();
        ops.put("k1", name, Integer.toString(value));

        return HttpStatus.OK;
    }

}
