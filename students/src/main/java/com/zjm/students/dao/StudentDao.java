package com.zjm.students.dao;


import com.zjm.students.entity.po.Student;
import com.zjm.students.entity.vo.Paramss;

import java.util.List;

public interface StudentDao {
    Integer querycount(Paramss params);

    List<Student> querystudent(Paramss params);

    void insertstudent(Student student);

    void deletestudent(Integer id);

    Student selectstudentById(Integer id);

    void updatestudent(Student student);
}
