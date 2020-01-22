package cn.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.mybatis.pojo.User;

public interface UserMapper {

	@Select("select * from user")
	List<User> getUsers(); // 查询数据

	// 方法存在多个参数，所有参数前面必须装上@Param("")注解
	@Select("select * from user where id=#{id}")
	User getUserById(@Param("id") int id);// 根据id查询数据

	@Insert("insert into user values(#{id},#{name},#{password})")
	int addUser(User user); // 插入数据

	@Update("update user set id=#{id},name=#{name},pwd=#{password} where id=#{id}")
	int editUser(User user); // 修改数据

	@Delete("delete from user where id=#{id}")
	int delete(int id); // 删除数据
}
