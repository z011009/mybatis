package cn.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

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
		UserDaoTest.getList(); // 获取数据
		// UserDaoTest.getUserById();//根据id获取数据
		// UserDaoTest.addUser();//添加
		// UserDaoTest.editUser();//修改
		// UserDaoTest.delUser(); // 根据id删除
	}

	private static void getList() {
		// 第一步获取sqisession
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		// 方式一
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = mapper.getList();
		// 方式二
		// List<User> list = sqlSession.selectList("cn.mybatis.dao.UserDao.getList");
		for (User user : list) {
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
	}

	private static void addUser() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		int addUser = mapper.addUser(new User(4, "wangwu", "222222"));
		if (addUser > 0) {
			System.out.println("插入成功");
		}
		// 提交事务
		sqlSession.commit();
		sqlSession.close();
	}

	private static void editUser() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		int editUser = mapper.editUser(new User(4, "zhaokiu", "123456"));
		if (editUser > 0) {
			System.out.println("修改成功");
		}
		// 提交事务
		sqlSession.commit();
		sqlSession.close();
	}

	private static void delUser() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		int delUser = mapper.delUser(4);
		if (delUser > 0) {
			System.out.println("删除成功");
		}
		// 提交事务
		sqlSession.commit();
		sqlSession.close();
	}
}
