package com.zjm.user.dao;

import com.zjm.user.entity.po.User;
import com.zjm.user.entity.vo.PageParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {

    @Select("<script>  select count(1) from z_user  where 1=1" +
            " <if test='name != null and name != &quot;%null%&quot;'>  and name  like #{name}</if>" +
            "  </script>")
    Long queryCount(PageParam param);
    @Select("<script>  select * from z_user where 1=1" +
            " <if test='name != null and name != &quot;%null%&quot;'>  and name  like #{name}</if>" +
            " limit #{startIndex},#{limit} </script>")
    List<User> queryDateByPage(PageParam param);
    @Select("select * from z_user where id=#{id}")
    User queryByid(Integer id);
    @Update("update z_user set password=#{password} where id=#{id}")
    void updateUser(User user);
    @Delete("delete from z_user where id=#{id}")
    void delUser(Integer id);
    @Select("select * from z_user where name =#{name}")
    User queryUserByname(String name);
    @Insert("insert into t_user " +
            "(name,password,createDate)" +
            "value" +
            "(#{name},#{password},#{createDate})")
    void addUser(User user);
}
