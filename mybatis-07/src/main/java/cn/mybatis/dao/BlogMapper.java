package cn.mybatis.dao;

import java.util.List;
import java.util.Map;

import cn.mybatis.pojo.Blog;

public interface BlogMapper {
	// 插入数据
	int addBlog(Blog blog);

	// 查询博客
	List<Blog> ListIF(Map map);

	List<Blog> ListChoose(Map map);

	// 更新博客
	int updateBlog(Map map);
	
	//查询1-3号记录的博客
	List<Blog> getBlogForeach(Map map);

}
