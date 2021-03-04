package com.zjm.students.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

// 业务bean
public class Paramss {
    private  Integer start;
    private Integer size;
    private String logContent;
    private String author;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birthdaymin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birthdaymax;
    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getBirthdaymin() {
        return birthdaymin;
    }

    public void setBirthdaymin(Date birthdaymin) {
        this.birthdaymin = birthdaymin;
    }

    public Date getBirthdaymax() {
        return birthdaymax;
    }

    public void setBirthdaymax(Date birthdaymax) {
        this.birthdaymax = birthdaymax;
    }
}
