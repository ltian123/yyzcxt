package com.hg.yyzcxt.dao;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hg.yyzcxt.entity.Role;
import com.hg.yyzcxt.entity.User;
import com.hg.yyzcxt.entity.UserRoleMap;
import com.hg.yyzcxt.utils.MyMapper;

/**
 * 用户数据访问对象
 * @author 
 *
 */
@Repository("userRoleMapDao")
public interface UserRoleMapDao  extends MyMapper<UserRoleMap> {
		
	/**
	 * 查询
	 * 根据角色id查找角色下全部用户
	 * @param roleId    start    end
	 * @return
	 */
	public List<User> selectUsersbyRoleId(Map<String, Object> map);
	/**
	 * 查询
	 * 统计 根据角色id查找角色下全部用户 数量
	 * @param roleId
	 * @return
	 */
	public int countUsersbyRoleId(String roleId);
	
	/**
	 * 查询
	 * 根据用户id查找用户拥有的全部角色
	 * @param userId   start    end
	 * @return
	 */
	public List<Role> selectRoleByUserId(Map<String, Object> map);
	
	/**
	 * 查询
	 * 统计 根据用户id查找用户拥有的全部角色 数量
	 * @param userId
	 * @return
	 */
	public int countRolesByUserId(String userId);
	
}

