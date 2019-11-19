package com.hg.yyzcxt.service.impl;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.hg.yyzcxt.utils.PageResults;
import com.hg.yyzcxt.BaseTest;
import com.hg.yyzcxt.entity.Role;
import com.hg.yyzcxt.service.RoleService;

public class RoleServiceImplTest extends BaseTest{

	@Autowired
	private RoleService roleService;
//	@Test
//	public void testupdateEntityById() throws Exception {
//		Role u = new Role();
//		u.setId("1");
//		u.setField1("110");
//			roleService.updateRoleById(u);
//		System.out.println("updateById"+u);
//	}
//	@Test
//	public void testremoveEntityrsByids() throws Exception {
//		String[] ids = {"11","12"};
//		int i = roleService.removeRolesByids(ids);
//		System.out.println("updateUserById"+i);
//	}
//	
//	@Test
//	public void testqueryEntityOneById()throws Exception {
//		Role u = roleService.queryRoleOneById("1");
//		System.out.println("queryRoleOneById"+u);
//	}
//	@Test
//	public void testselmany()  throws Exception{
//		Role u = new Role();
//		u.setName("1");
//		PageResults<Role> pr = roleService.queryRoleListPaged(u, 1, 5);
//		System.out.println("//testselmany总记录数"+pr.getTotalCount());
//		for(Role role:pr.getResults()) {
//			System.out.println(role);
//		}
//	}
//	@Test
//	public void testselAll()  throws Exception{
//		PageResults<Role> pr = roleService.queryRoleAll();
//		System.out.println("//testselAll总记录数"+pr.getTotalCount());
//		for(Role role:pr.getResults()) {
//			System.out.println(role);
//		}
//	}
//	@Test
//	public void testInsertEntity()throws Exception {
//		Role role = new Role();
//		role.setName("1121");
//		roleService.saveRole(role);
//		System.out.println("testInsertEntity"+role);
//	}
	
	
}
