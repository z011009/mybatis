package cn.mybatis.dao;

import java.util.List;

import cn.mybatis.pojo.Student;

public interface StudentMapper {
	// 查询所有的学生信息以及对应的老师信息
	List<Student> getStudent();

	// 查询所有的学生信息以及对应的老师信息
	List<Student> getStudent2();
}
