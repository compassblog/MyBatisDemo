package com.mybatis.test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.dao.UserDao;
import com.mybatis.pojo.User;

public class Test {

	public static void main(String[] args) {

		//加载MyBatis配置文件
		InputStream is = Test.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

		//获取SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//获取实现接口的代理对象
		UserDao userDAO = sqlSession.getMapper(UserDao.class);
		
		//新增用户
		User user = new User();
		user.setUsername("孔乙己");
		user.setPassword("123456");
		user.setAge(21);
		System.out.println(userDAO.addUser(user));
		System.out.println("测试成功！");
		sqlSession.commit();
		
//		//删除用户
//		System.out.println(userDAO.deleteUser(1));
//		sqlSession.commit();
//
//		//查询用户
//		User user1 = userDAO.selectUserById(1);
//		System.out.println(user1);
//
//		//修改用户
//		User user2 = userDAO.selectUserById(1);
//		user2.setUsername("指南者");
//		System.out.println(userDAO.updateUser(user2));
//		sqlSession.commit();

	}
}
