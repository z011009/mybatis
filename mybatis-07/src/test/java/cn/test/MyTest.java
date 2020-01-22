package cn.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.mybatis.dao.BlogMapper;
import cn.mybatis.pojo.Blog;
import cn.mybatis.util.IDutils;
import cn.mybatis.util.MybatisUtil;

public class MyTest {
	public void addTest() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

		Blog blog = new Blog();
		blog.setId(IDutils.getId());
		blog.setTitle("Mybatis如此简单");
		blog.setAuthor("无垢");
		blog.setCreateTime(new Date());
		blog.setViews(9999);
		mapper.addBlog(blog);

		blog.setId(IDutils.getId());
		blog.setTitle("Java如此简单");
		mapper.addBlog(blog);

		blog.setId(IDutils.getId());
		blog.setTitle("Spring如此简单");
		mapper.addBlog(blog);

		sqlSession.close();
	}

	public void testIF() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

		HashMap map = new HashMap();
		// map.put("title", "Mybatis如此简单");
		map.put("author", "无垢");
		List<Blog> listIF = mapper.ListIF(map);
		for (Blog blog : listIF) {
			System.out.println(blog);
		}
		sqlSession.close();
	}

	@Test
	public void testForeach() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

		HashMap map = new HashMap();

		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("1");
		arrayList.add("2");
		map.put("ids", arrayList);

		List<Blog> blogForeach = mapper.getBlogForeach(map);
		for (Blog blog : blogForeach) {
			System.out.println(blog);
		}
		sqlSession.close();
	}

	public void testchoose() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
		HashMap map = new HashMap();
		// map.put("author", "无垢");
		map.put("title", "Java如此简单");
		map.put("views", 9999);
		List<Blog> listIF = mapper.ListChoose(map);
		for (Blog blog : listIF) {
			System.out.println(blog);
		}
		sqlSession.close();
	}

	public void updateBlog() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

		Map map = new HashMap();
		// map.put("title", "Java如此简单2");
		map.put("author", "无垢2");
		map.put("id", "53debdff54ba43c9ad38206c11cd1499");
		mapper.updateBlog(map);

		sqlSession.close();
	}
}
