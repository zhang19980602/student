package com.zjm.user.controller;

import com.zjm.user.entity.po.User;
import com.zjm.user.entity.vo.PageParam;
import com.zjm.user.entity.vo.PageResult;
import com.zjm.user.entity.vo.ReponseData;
import com.zjm.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/user/")
public class UserController {
    @Autowired
    private UserService userService;
    /*   1    查询所有的用户（分页）
     路径   http://localhost:8080/api/user/getData
     get请求
    参数:limit(每页条数) page（当前页）
     返回值
          "code": 0,
         "msg": "处理成功",
         "count": ,
         "data": []
         */
    // @log_zzh("用户查询")
    @GetMapping("getData")
    public PageResult<User> getData(PageParam param){
        PageResult<User> rs = userService.getData(param);
        return rs;
    }
    /*      回显
     路径   http://localhost:8080/api/user/queryByid
     get请求
    参数:limit(每页条数) page（当前页）
     返回值
          "code": 0,
         "msg": "处理成功",
         "count": ,
         "data": []
         */
    // @log_zzh("用户回显")
    @PostMapping("queryByid")
    public ReponseData queryByid(Integer id){
        User user = userService.queryByid(id);
        return ReponseData.success(user);
    }
    /*      修改
     路径   http://localhost:8080/api/user/updateUser
     get请求
    参数:limit(每页条数) page（当前页）
     返回值
          "code": 0,
         "msg": "处理成功",
         "count": ,
         "data": []
         */
    // @log_zzh("用户修改")
    @PostMapping("updateUser")
    public ReponseData updateUser(User user){
        userService.updateUser(user);
        return ReponseData.success(null);
    }
    /*      修改
   路径   http://localhost:8080/api/user/del
   get请求
  参数:limit(每页条数) page（当前页）
   返回值
        "code": 0,
       "msg": "处理成功",
       "count": ,
       "data": []
       */
    //  @log_zzh("用户删除")
    @PostMapping("delUser")
    public ReponseData delUser(Integer id){
        userService.delUser(id);
        return ReponseData.success(null);
    }
/*   注册
   路径  http://localhost:8080/api/login/addUser
   请求 post
  参数:name,realName,password,sex,phone,email,idCard,birthday,imgPath,eduId,deptId,
   返回值
         status": 200,
            "info": "处理成功",
            "data": null
       */

    @PostMapping("addUser")
    public ReponseData addUser(User user){
        User user1 =userService.queryUserByname(user.getName());
        if (user1==null){
            userService.addUser(user);
        }else{
            return ReponseData.success(2);
        }
        return ReponseData.success(1);
    }
    /*   登录
  路径   http://localhost:8080/api/login/userLogin
  请求 post
 参数:name , password
  返回值
       map
      */
    @RequestMapping("userLogin")
    public Map userLogin(String name, String password){

        Map map = new HashMap();
        User user =userService.queryUserByname(name);
        if (user != null){
            if (password.equals(user.getPassword())){
                map.put("msg",3);
            }else{
                map.put("msg",2);
            }
        }else{
            map.put("msg",1);
        }
        return map;
    }
}
