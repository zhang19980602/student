package com.zjm.rizhi.utils;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {

    private static JedisPool jedisPool;

    //代码块 只执行一次
    static {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //最小连接数
        poolConfig.setMinIdle(2);
        //最大连接数
        poolConfig.setMaxIdle(5);
        //初始化连接池对象
        jedisPool = new JedisPool(poolConfig , "192.168.26.131" , 6379 , 0 , "123");
    }

    public static String get(String key){
        Jedis resource = jedisPool.getResource();
        String value = resource.get(key);
        jedisPool.returnResource(resource);
        return value;
    }

    public static String set(String key , Object data){
        String s = JSONObject.toJSONString(data);
        Jedis resource = jedisPool.getResource();
        String set = resource.set(key, s);
        return set;
    }

    public static String set(String key , String data){
        Jedis resource = jedisPool.getResource();
        String set = resource.set(key, data);
        return set;
    }

    public static  String hget(String key,String field){
        Jedis resource = jedisPool.getResource();
        String set = resource.hget(key,field);
        jedisPool.returnResource(resource);
        return set;
    }

}
