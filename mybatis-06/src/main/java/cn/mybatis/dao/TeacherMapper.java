package cn.mybatis.dao;

import org.apache.ibatis.annotations.Param;

import cn.mybatis.pojo.Teacher;

public interface TeacherMapper {

	// 获取老师
	// List<Teacher> getTeacher();

	// 获取指定老师下的所有学生及老师信息
	Teacher getTeacher(@Param("tid") int id);

	// 获取指定老师下的所有学生及老师信息
	Teacher getTeacher2(@Param("tid") int id);
}
