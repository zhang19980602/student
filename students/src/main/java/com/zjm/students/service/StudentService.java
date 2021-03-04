package com.zjm.students.service;



import com.zjm.students.entity.po.Student;
import com.zjm.students.entity.vo.Paramss;

import java.util.Map;

public interface StudentService {
    Map querystudent(Paramss params);

    void insertstudent(Student student);

    void deletestudent(Integer id);

    Student selectstudentById(Integer id);

    void updatestudent(Student student);
}
