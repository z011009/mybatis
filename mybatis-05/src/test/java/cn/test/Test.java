package cn.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.mybatis.dao.StudentMapper;
import cn.mybatis.dao.TeacherMapper;
import cn.mybatis.pojo.Student;
import cn.mybatis.pojo.Teacher;
import cn.mybatis.util.MybatisUtil;

public class Test {
	public static void main(String[] args) {
		// Test.getStu();
		Test.getStu2();
		// Test.getTea();
	}

	private static void getTea() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
		Teacher teacher = mapper.getTeacher(1);
		System.out.println(teacher);
		sqlSession.close();
	}

	private static void getStu() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> student = mapper.getStudent();
		for (Student stu : student) {
			System.out.println(stu);
		}
		sqlSession.close();
	}

	private static void getStu2() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> student = mapper.getStudent2();
		for (Student stu : student) {
			System.out.println(stu);
		}
		sqlSession.close();
	}
}
