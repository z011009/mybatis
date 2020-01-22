package cn.mybatis.pojo;

import java.util.List;

import lombok.Data;

@Data
public class Teacher {
	private int id;
	private String name;
	
	// 一个老师对应多个学生
	private List<Student> students;
}
