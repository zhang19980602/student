package com.zjm.rizhi.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zjm.rizhi.model.Log;
import com.zjm.rizhi.service.LogService;
import com.zjm.rizhi.utils.RedisUtil;
import com.zjm.rizhi.vo.ReponseData;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/log")
public class LogController {

    @Resource
    private LogService logService;

    //新增
    @RequestMapping("addLog")
    public ReponseData addLog(Log log){
        if (log == null){
            return ReponseData.error(500,"数据不能为空");
        }

        return ReponseData.success(logService.addLog(log));
    }

    //查询
    @RequestMapping("queryLog")
    public ReponseData queryLog(){
        //获取redis里的数据
        String log = RedisUtil.get("log");
        //查数据库里的值  放入redis中
        List<Log> logList = logService.queryLog();
        //将数据转换为json字符串
        log = JSONObject.toJSONString(logList);
        //将转换后的数据存到redis中
        RedisUtil.set("log" , log);
        //将字符串转为JSON数组
        JSONArray objects = JSONArray.parseArray(log);
        return ReponseData.success(objects);
    }

}
