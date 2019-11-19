package com.hg.yyzcxt.service;

import org.springframework.stereotype.Repository;

import com.hg.yyzcxt.entity.Role;
import com.hg.yyzcxt.entity.User;
import com.hg.yyzcxt.entity.UserRoleMap;
import com.hg.yyzcxt.utils.PageResults;

@Repository("userRoleMapService")
public interface UserRoleMapService {
	
	/**
	 * 增加
	 * 新增用户角色关系映射
	 * @param userRoleMap
	 * @return
	 * @throws Exception
	 */
	public int saveUserRoleMap(UserRoleMap userRoleMap) throws Exception;
	/**
	 * 删除
	 * 根据用户id和角色id，删除用户角色关系映射
	 * @param userId 用户 id    roleId角色id
	 * @return
	 * @throws Exception
	 */
	public int removeUserRoleMapsByuserIdAndRoleId(String userId,String roleId) throws Exception;
	/**
	 * 删除
	 * 根据用户角色关系映射id数组，删除批量用户角色关系映射
	 * @param ids 用户角色关系映射id数组
	 * @return
	 * @throws Exception
	 */
	public int removeUserRoleMapsByids(String[] ids) throws Exception;
	/**
	 * 删除
	 * 根据用户id，删除批量用户角色关系映射
	 * @param id 用户id
	 * @return
	 * @throws Exception
	 */
	public int removeUserRoleMapsByuserid(String userId) throws Exception;
	/**
	 * 删除
	 * 根据角色id，删除批量用户角色关系映射
	 * @param id 角色id
	 * @return
	 * @throws Exception
	 */
	public int removeUserRoleMapsByroleid(String roleId) throws Exception;
	/**
	 * 更新
	 * 根据用户角色关系映射id ，更新用户角色关系映射详情 ，根据主键进行更新，只会更新不是null的数据
	 * @param 用户角色关系映射
	 * @return
	 * @throws Exception
	 */
	public int updateUserRoleMapById(UserRoleMap userRoleMap) throws Exception;
	
	/**
	 * 查询
	 * 根据id查询单个用户角色关系映射 详情
	 * @param id  主键id
	 * @return 用户角色关系映射UserRoleMap
	 */
	public UserRoleMap queryUserRoleMapOneById(String id) throws Exception;
	/**
	 * 查询
	 * 分页查询
	 * @param page 第几页  从1开始
	 * @param pageSize 一页个数
	 * @return
	 * @throws Exception
	 */
	public PageResults<UserRoleMap> queryUserRoleMapListPaged( Integer page, Integer pageSize)throws Exception;
	/**
	 * 查询全部用户角色关系映射
	 * @return
	 * @throws Exception
	 */
	public PageResults<UserRoleMap> queryUserRoleMapAll()throws Exception;
	/**
	 * 查询
	 * 根据角色id查找角色下全部用户
	 * @param roleId    start    end
	 * @return
	 */
	public PageResults<User> queryUsersbyRoleId(String  roleId,Integer page, Integer pageSize) throws Exception;
	/**
	 * 查询
	 * 根据用户id查找用户拥有的全部角色
	 * @param userId   start    end
	 * @return
	 */
	public PageResults<Role> queryRoleByUserId(String userId,Integer page, Integer pageSize) throws Exception;
}
