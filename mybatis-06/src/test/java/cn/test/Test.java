package cn.test;

import org.apache.ibatis.session.SqlSession;

import cn.mybatis.dao.TeacherMapper;
import cn.mybatis.pojo.Teacher;
import cn.mybatis.util.MybatisUtil;

public class Test {
	public static void main(String[] args) {
		Test.getTea();
	}

	public static void getTea() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		Teacher teacher = sqlSession.getMapper(TeacherMapper.class).getTeacher2(1);
		System.out.println(teacher);
		/*
		Teacher(id=1, name=吴老师, students=[Student(id=1, name=小明, tid=1),
		Student(id=2, name=小花, tid=1),
		Student(id=3, name=小张, tid=1),
		Student(id=4, name=小王, tidX=1)])
		*/
		sqlSession.close();
	}
}
