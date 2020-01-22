package cn.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.mybatis.dao.UserMapper;
import cn.mybatis.pojo.User;
import cn.mybatis.util.MybatisUtil;

public class MyTest {
	@Test
	public void getUser() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		SqlSession sqlSession2 = MybatisUtil.getSqlSession();

		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> user = mapper.getUser(1);
		System.out.println(user);
		sqlSession.close();

		UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
		List<User> user2 = mapper2.getUser(1);
		System.out.println(user2);

		System.out.println(user == user2);
		sqlSession2.close();
	}
}
