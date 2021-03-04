package com.zjm.user.service;

import com.zjm.user.entity.po.User;
import com.zjm.user.entity.vo.PageParam;
import com.zjm.user.entity.vo.PageResult;

public interface UserService {
    PageResult<User> getData(PageParam param);

    User queryByid(Integer id);

    void updateUser(User user);

    void delUser(Integer id);

    User queryUserByname(String name);

    void addUser(User user);
}
