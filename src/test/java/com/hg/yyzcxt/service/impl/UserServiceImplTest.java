package com.hg.yyzcxt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.hg.yyzcxt.BaseTest;
import com.hg.yyzcxt.entity.User;
import com.hg.yyzcxt.service.UserService;
import com.hg.yyzcxt.utils.PageResults;

public class UserServiceImplTest extends BaseTest{

	@Autowired
	private UserService userService;
//	@Test
//	public void testupdateUserById() throws Exception {
//		User u = new User();
//		u.setId("3");
//		u.setPhone("110");
//			userService.updateUserById(u);
//		System.out.println("updateUserById"+u);
//	}
//	@Test
//	public void testremoveUsersByids() throws Exception {
//		String[] ids = {"180626C2WWZT0ZR4","11"};
//		int i = userService.removeUsersByids(ids);
//		System.out.println("updateUserById"+i);
//	}
	
//	@Test
//	public void testqueryUserOneById()throws Exception {
//		User u = userService.queryUserOneById("11");
//		System.out.println("queryUserOneById"+u);
//	}
//	@Test
//	public void testselmany()  throws Exception{
//		User u = new User();
//		u.setUsername("admin");
//		PageResults<User> pr = userService.queryUserListPaged(u, 1, 5);
//		System.out.println("//总记录数"+pr.getTotalCount());
//		for(User user:pr.getResults()) {
//			System.out.println(user);
//		}
//	}
//	@Test
//	public void testregist()throws Exception {
//		User u = new User();
//		u.setUsername("1121");
//		u.setPassword("11");
//		userService.regist(u);
//		System.out.println("regist"+u);
//	}
	
//	@Test
//	public void testlogin()throws Exception {
//		User u = userService.login("1121", "11");
//		System.out.println("login"+u);
//	}
//	
	@Test
	public void validateUsername()throws Exception {
		try {
			userService.validateUsername("1121");
		} catch (Exception e) {
			System.out.println("validateUsername()"+e.getMessage());
		}
		
		
	}
	
}
