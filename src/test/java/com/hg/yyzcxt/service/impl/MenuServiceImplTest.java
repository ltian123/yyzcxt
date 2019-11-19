package com.hg.yyzcxt.service.impl;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.hg.yyzcxt.utils.PageResults;
import com.hg.yyzcxt.BaseTest;
import com.hg.yyzcxt.entity.Menu;
import com.hg.yyzcxt.service.MenuService;

public class MenuServiceImplTest extends BaseTest{

	@Autowired
	private MenuService menuService;
//	@Test
//	public void testupdateEntityById() throws Exception {
//		Menu u = new Menu();
//		u.setId("3");
//		u.setField1("1");
//			menuService.updateMenuById(u);
//		System.out.println("updateById"+u);
//	}
	@Test
	public void testremoveEntityrsByids() throws Exception {
		String[] ids = {"11","112"};
		int i = menuService.removeMenusByids(ids);
		System.out.println("updateUserById"+i);
	}
//	
//	@Test
//	public void testqueryEntityOneById()throws Exception {
//		Menu u = menuService.queryMenuOneById("12");
//		System.out.println("queryMenuOneById"+u);
//	}
//	@Test
//	public void testselmany()  throws Exception{
//		Menu u = new Menu();
////		u.setName("admin");
//		PageResults<Menu> pr = menuService.queryMenuListPaged(u, 1, 5);
//		System.out.println("//testselmany总记录数"+pr.getTotalCount());
//		for(Menu menu:pr.getResults()) {
//			System.out.println(menu);
//		}
//	}
//	@Test
//	public void testselAll()  throws Exception{
//		PageResults<Menu> pr = menuService.queryMenuAll();
//		System.out.println("//testselAll总记录数"+pr.getTotalCount());
//		for(Menu menu:pr.getResults()) {
//			System.out.println(menu);
//		}
//	}
//	@Test
//	public void testInsertEntity()throws Exception {
//		Menu menu = new Menu();
//		menu.setName("1121");
//		menuService.saveMenu(menu);
//		System.out.println("testInsertEntity"+menu);
//	}
	
	
}
