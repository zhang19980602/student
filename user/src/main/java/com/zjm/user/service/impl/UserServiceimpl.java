package com.zjm.user.service.impl;

import com.zjm.user.dao.UserDao;
import com.zjm.user.entity.po.User;
import com.zjm.user.entity.vo.PageParam;
import com.zjm.user.entity.vo.PageResult;
import com.zjm.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceimpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public PageResult<User> getData(PageParam param) {
        param.setName("%"+param.getName()+"%");
        Long count = userDao.queryCount(param);
        //查询某页的数据    1  2 ----   0,2    2,2  ---- 2,2     3,3   ----   4,2
        param.setStartIndex((param.getPage()-1)*param.getLimit());//开始下标
        List<User> data = userDao.queryDateByPage(param);
        //构建 layui  table 需要的数据{code：0，msg："",data:[],count:}
        PageResult<User> rs=new PageResult<>(count,data);
        return rs;
    }

    @Override
    public User queryByid(Integer id) {
        return userDao.queryByid(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void delUser(Integer id) {
        userDao.delUser(id);
    }

    @Override
    public User queryUserByname(String name) {
        User user =userDao.queryUserByname(name);
        return user;
    }

    @Override
    public void addUser(User user) {
        user.setCreateDate(new Date());
        userDao.addUser(user);
    }
}
