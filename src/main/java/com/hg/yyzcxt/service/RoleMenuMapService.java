package com.hg.yyzcxt.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hg.yyzcxt.entity.Menu;
import com.hg.yyzcxt.entity.RoleMenuMap;
import com.hg.yyzcxt.utils.PageResults;

@Repository("roleMenuMapService")
public interface RoleMenuMapService {
	
	/**
	 * 增加
	 * 新增角色菜单关系映射
	 * @param roleMenuMap
	 * @return
	 * @throws Exception
	 */
	public int saveRoleMenuMap(RoleMenuMap roleMenuMap) throws Exception;
	/**
	 * 删除
	 * 根据角色菜单关系映射id数组，删除批量角色菜单关系映射
	 * @param ids 角色菜单关系映射id数组
	 * @return
	 * @throws Exception
	 */
	public int removeRoleMenuMapsByids(String[] ids) throws Exception;
	/**
	 * 更新
	 * 根据角色菜单关系映射id ，更新角色菜单关系映射详情 ，根据主键进行更新，只会更新不是null的数据
	 * @param 角色菜单关系映射
	 * @return
	 * @throws Exception
	 */
	public int updateRoleMenuMapById(RoleMenuMap roleMenuMap) throws Exception;
	
	/**
	 * 查询
	 * 根据id查询单个角色菜单关系映射详情
	 * @param id  主键id
	 * @return 角色菜单关系映射RoleMenuMap
	 */
	public RoleMenuMap queryRoleMenuMapOneById(String id) throws Exception;
	/**
	 * 查询
	 * 分页查询
	 * @param 角色菜单关系映射   属性name模糊查询 ,可不传
	 * @param page 第几页  从1开始
	 * @param pageSize 一页个数
	 * @return
	 * @throws Exception
	 */
	public PageResults<RoleMenuMap> queryRoleMenuMapListPaged( Integer page, Integer pageSize)throws Exception;
	/**
	 * 查询全部角色菜单关系映射
	 * @return
	 * @throws Exception
	 */
	public PageResults<RoleMenuMap> queryRoleMenuMapAll()throws Exception;
	/**
	 * 查询
	 * 根据角色id  查找角色下   全部菜单
	 * @param roleId   
	 * @return
	 */
	public List<Menu> queryAllMenusbyRoleId(String roleId);
	/**
	 * 查询
	 * 根据用户id  查找user下   全部菜单
	 * @param roleId   
	 * @return
	 */
	public List<Menu> queryAllMenusbyUserId(String userId);
	
	/**
	 * 查询
	 * 根据用户id and 菜单id 查找user下   RoleMenuMap
	 * @param menuId  userId
	 * @return
	 */
	public RoleMenuMap queryRoleMenuMapbyUserIdandMenuId(String menuId,String userId);
	
}
