package com.zjm.rizhi.service;

import com.zjm.rizhi.model.Log;

import java.util.List;

public interface LogService {
    Object addLog(Log log);

    List<Log> queryLog();

}
