package cn.mybatis.dao;

import java.util.List;
import java.util.Map;

import cn.mybatis.pojo.User;

public interface UserMapper {
	//获取全部用户
	List<User> getList();
	//模糊查询
	List<User> getList2(Map<String, Object> map);
	//根据id查询用户
	User getUserById(Integer id);
	//插入一个用户
	int addUser(User user);
	int addUser2(Map<String, Object> map);
	//修改用户
	int editUser(User user);
	//删除
	int delUser(int id);
}
