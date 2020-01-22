package cn.mybatis.util;

import java.util.UUID;

//@SuppressWarnings("all") //抑制警告
public class IDutils{
	public static String getId() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static void main(String[] args) {
		System.out.println(IDutils.getId());
	}
}
