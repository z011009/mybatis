package cn.mybatis.pojo;

import java.util.Date;

import lombok.Data;

@Data
public class Blog {
	private String id;
	private String title;
	private String author;
	private Date createTime; //属性名和字段名不一致
	private int views;
}
