package com.hg.yyzcxt.dao;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hg.yyzcxt.BaseTest;
import com.hg.yyzcxt.dao.UserDao;
import com.hg.yyzcxt.entity.User;


public class UserDaoTest extends BaseTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void testQueryById() throws Exception {
		String userId ="2";
		User u = userDao.selectByPrimaryKey(userId);
		System.out.println(u);
	}



}
