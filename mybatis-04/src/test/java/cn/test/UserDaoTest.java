package cn.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import cn.mybatis.dao.UserMapper;
import cn.mybatis.pojo.User;
import cn.mybatis.util.MybatisUtil;

/**
 * 测试
 * 
 * @author Administrator
 *
 */
public class UserDaoTest {
	public static void main(String[] args) {
		UserDaoTest.test();
	}

	private static void test() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		List<User> users = mapper.getUsers();
		for (User user : users) {
			System.out.println(user);
		}

//		User userById = mapper.getUserById(1);
//		System.out.println(userById);
		
//		int addUser = mapper.addUser(new User(6,"wugou","1009"));
		
//		int editUser = mapper.editUser(new User(6,"wg","12345"));
		
//		int delete = mapper.delete(6);
		sqlSession.close();
	}
}
