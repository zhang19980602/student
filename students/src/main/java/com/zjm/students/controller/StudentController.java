package com.zjm.students.controller;

import com.zjm.students.entity.po.Student;
import com.zjm.students.entity.vo.Paramss;
import com.zjm.students.entity.vo.ResponseData;
import com.zjm.students.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("api/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    /*
     * 查询学生信息
     * 路径： http://localhost:8080/api/student/querystudent
     * 请求方式 get
     *
     * 参数
     *
     *
     *
     * start （当前页）  （必选）
     *
     * size （每页条数） （必选）
     *
     * 返回值
     *  code  info   date:{list  count}
     *
     * */

    @GetMapping("querystudent")
    public ResponseData querystudent(Paramss params){
        if (params.getStart()==null){
            return ResponseData.error(400,"起始小标不能为空");
        }
        if (params.getSize()==null){
            return ResponseData.error(400,"每页条数不能为空");
        }
        Map map= studentService.querystudent(params);
        return ResponseData.success(map);
    }
    /*
     * 新增学生信息
     * 路径： http://localhost:8080/api/student/insertstudent
     * 请求方式 post
     *
     * 参数  student
     *
     * 返回值
     *  code  info   date:null
     *
     * */
    @PostMapping("insertstudent")
    public  ResponseData insertstudent(Student student){
        if(student==null){
            return ResponseData.error(400,"对象不能为空");
        }
        studentService.insertstudent(student);
        return ResponseData.success(null);
    }

    /*
     * 删除学生信息
     * 路径： http://localhost:8080/api/student/deletestudent
     * 请求方式 post
     *
     * 参数
     *  id
     * 返回值
     *  code  info   date:null
     *
     * */

    @PostMapping("deletestudent")
    public ResponseData deletestudent(Integer id){
        if(id==null){
            return ResponseData.error(400,"id不能为空");
        }
        studentService.deletestudent(id);
        return ResponseData.success(null);
    }
    /*
     * 根据id查询学生信息
     * 路径： http://localhost:8080/api/student/selectstudentById
     * 请求方式 post
     *
     * 参数
     *  id
     * 返回值
     *  code  info   date:null
     *
     * */

    @PostMapping("selectstudentById")
    public ResponseData selectstudentById(Integer id){
        if(id==null){
            return ResponseData.error(400,"id不能为空");
        }
        Student student=studentService.selectstudentById(id);
        return ResponseData.success(student);
    }
    /*
     * 修改学生信息
     * 路径： http://localhost:8080/api/student/updatestudent
     * 请求方式 post
     *
     * 参数
     *  id
     * 返回值
     *  code  info   date:null
     *
     * */
    @PostMapping("updatestudent")
    public ResponseData updatestudent(Student student){
        if(student==null){
            return ResponseData.error(400,"对象不能为空");
        }
        studentService.updatestudent(student);
        return ResponseData.success(null);
    }
    }
