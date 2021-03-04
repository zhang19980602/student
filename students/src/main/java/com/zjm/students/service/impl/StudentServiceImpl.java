package com.zjm.students.service.impl;

import com.zjm.students.dao.StudentDao;
import com.zjm.students.entity.po.Student;
import com.zjm.students.entity.vo.Paramss;
import com.zjm.students.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public Map querystudent(Paramss params) {
        Map map =new HashMap();
      Integer count=  studentDao.querycount(params);
      map.put("count",count);
        List<Student> list =studentDao.querystudent(params);
        map.put("list",list);
        return map;
    }

    @Override
    public void insertstudent(Student student) {
        studentDao.insertstudent(student);
    }

    @Override
    public void deletestudent(Integer id) {
        studentDao.deletestudent(id);
    }

    @Override
    public Student selectstudentById(Integer id) {

        Student student =studentDao.selectstudentById(id);
        return student;
    }

    @Override
    public void updatestudent(Student student) {
        studentDao.updatestudent(student);
    }
}
