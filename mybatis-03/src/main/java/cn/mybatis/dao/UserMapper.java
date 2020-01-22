package cn.mybatis.dao;

import java.util.List;
import java.util.Map;

import cn.mybatis.pojo.User;

public interface UserMapper {
	// 根据id查询用户
	User getUserById(Integer id);

	// 分页
	List<User> getUserByLimit(Map<String, Object> map);

	// 分页2
	List<User> getUserByRows();
}
