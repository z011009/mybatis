package cn.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.mybatis.pojo.User;

@SuppressWarnings("all") //抑制警告
public interface UserMapper {
	// 根据id查询用户
	// @Select("select * from user where id=#{id}")
	List<User> getUser(@Param("id") int id);

	// @Update("update user set name=#{name},pwd=#{pwd} where id=#{id}")
	int updateUser(User user);
}
