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
		// UserDaoTest.getUserById();// 根据id获取数据
		// UserDaoTest.testLog4j();
		//UserDaoTest.getUserByLimit();// 分页
		UserDaoTest.getUserByRows();
	}

	private static void getUserByRows() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		RowBounds rowBounds = new RowBounds(0,2);
		List<User> selectList = sqlSession.selectList("cn.mybatis.dao.UserMapper.getUserByRows",null,rowBounds);
		for (User user : selectList) {
			System.out.println(user);
		}
		sqlSession.close();
	}

	private static void getUserById() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User userById = mapper.getUserById(1);
		System.out.println(userById);
		sqlSession.close();
		// select * from user where id=#{id}
		// 类型处理器
		// select id,name,pwd from user where id=#{id}
	}

	private static void getUserByLimit() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startIndex", 0);
		map.put("pageSize", 2);
		List<User> userByLimit = mapper.getUserByLimit(map);
		for (User user : userByLimit) {
			System.out.println(user);
		}
		sqlSession.close();
	}

	private static void testLog4j() {
		Logger logger = Logger.getLogger(UserDaoTest.class);
		logger.info("info:进入了testLog4j");
		logger.debug("debug:进入了testLog4j");
		logger.error("error:进入了testLog4j");
	}
}
