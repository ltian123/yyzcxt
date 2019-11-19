package com.hg.yyzcxt.service;



import org.springframework.stereotype.Repository;

import com.hg.yyzcxt.entity.Menu;
import com.hg.yyzcxt.utils.PageResults;

@Repository("menuService")
public interface MenuService {
	
	/**
	 * 增加
	 * 新增菜单
	 * @param menu
	 * @return
	 * @throws Exception
	 */
	public int saveMenu(Menu menu) throws Exception;
	/**
	 * 删除
	 * 根据菜单id数组，删除批量菜单
	 * @param ids 菜单id数组
	 * @return
	 * @throws Exception
	 */
	public int removeMenusByids(String[] ids) throws Exception;
	/**
	 * 更新
	 * 根据菜单id ，更新菜单详情 ，根据主键进行更新，只会更新不是null的数据
	 * @param 菜单
	 * @return
	 * @throws Exception
	 */
	public int updateMenuById(Menu menu) throws Exception;
	
	/**
	 * 查询
	 * 根据id查询单个菜单详情
	 * @param id  主键id
	 * @return 菜单Menu
	 */
	public Menu queryMenuOneById(String id) throws Exception;
	/**
	 * 查询
	 * 分页查询
	 * @param 菜单   属性name模糊查询
	 * @param page 第几页  从1开始
	 * @param pageSize 一页个数
	 * @return
	 * @throws Exception
	 */
	public PageResults<Menu> queryMenuListPaged(Menu menu, Integer page, Integer pageSize)throws Exception;
	/**
	 * 查询全部菜单
	 * @return
	 * @throws Exception
	 */
	public PageResults<Menu> queryMenuAll()throws Exception;
	
	
}
