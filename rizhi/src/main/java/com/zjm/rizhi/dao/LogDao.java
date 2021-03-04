package com.zjm.rizhi.dao;

import com.zjm.rizhi.model.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LogDao {

    @Insert("insert into log (content,ip,author) value (#{content},#{ip},#{author})")
    void addLog(Log log);

    @Select("select * from log")
    List<Log> queryLog();
}
