package com.hg.yyzcxt.dao;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hg.yyzcxt.entity.Menu;
import com.hg.yyzcxt.entity.RoleMenuMap;
import com.hg.yyzcxt.entity.User;
import com.hg.yyzcxt.utils.MyMapper;

/**
 * 用户数据访问对象
 * @author 
 *
 */
@Repository("roleMenuMapDao")
public interface RoleMenuMapDao  extends MyMapper<RoleMenuMap> {
		
	/**
	 * 查询
	 * 根据角色id  分页查找角色下   菜单
	 * @param roleId    start    end
	 * @return
	 */
	public List<Menu> selectMenusbyRoleId(Map<String, Object> map);
	/**
	 * 查询
	 * 统计 根据角色id查找角色下全部用户 数量
	 * @param roleId
	 * @return
	 */
	public int countMenusbyRoleId(String roleId);
	/**
	 * 查询
	 * 根据角色id  查找角色下   全部菜单
	 * @param roleId   
	 * @return
	 */
	public List<Menu> selectAllMenusbyRoleId(Map<String, Object> map);
	
	/**
	 * 查询
	 * 根据用户id  查找user下   全部菜单
	 * @param userId   
	 * @return
	 */
	public List<Menu>selectAllMenusbyUserId(Map<String, Object> map);
	
	/**
	 * 查询
	 * 根据用户id and 菜单id 查找user下   RoleMenuMap
	 * @param menuId  userId
	 * @return
	 */
	public RoleMenuMap selectRoleMenuMapbyUserIdandRoleId(Map<String, Object> map);
}

