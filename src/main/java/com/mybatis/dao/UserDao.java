package com.mybatis.dao;

import com.mybatis.pojo.User;

public interface UserDao {
	
	//新增用户
	public int addUser(User user);
	
	//根据id删除用户
	public int deleteUser(int id);
	
	//修改用户
	public int updateUser(User user);
	
	//根据id查询用户
	public User selectUserById(int id);
	
}
