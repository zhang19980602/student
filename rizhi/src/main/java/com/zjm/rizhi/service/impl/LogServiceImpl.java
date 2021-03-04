package com.zjm.rizhi.service.impl;

import com.zjm.rizhi.dao.LogDao;
import com.zjm.rizhi.model.Log;
import com.zjm.rizhi.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Resource
    private LogDao logDao;

    //新增
    public Object addLog(Log log) {
        logDao.addLog(log);
        return null;
    }

    //查询
    public List<Log> queryLog() {
        List<Log> logList = logDao.queryLog();
        return logList;
    }

}
