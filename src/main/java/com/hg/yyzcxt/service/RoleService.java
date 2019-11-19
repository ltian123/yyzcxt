package com.hg.yyzcxt.service;

import org.springframework.stereotype.Repository;
import com.hg.yyzcxt.entity.Role;
import com.hg.yyzcxt.utils.PageResults;

@Repository("roleService")
public interface RoleService {
	
	/**
	 * 增加
	 * 新增角色
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public int saveRole(Role role) throws Exception;
	/**
	 * 删除
	 * 根据角色id数组，删除批量角色
	 * @param ids 角色id数组
	 * @return
	 * @throws Exception
	 */
	public int removeRolesByids(String[] ids) throws Exception;
	/**
	 * 更新
	 * 根据角色id ，更新角色详情 ，根据主键进行更新，只会更新不是null的数据
	 * @param 角色
	 * @return
	 * @throws Exception
	 */
	public int updateRoleById(Role role) throws Exception;
	
	/**
	 * 查询
	 * 根据id查询单个角色详情
	 * @param id  主键id
	 * @return 角色Role
	 */
	public Role queryRoleOneById(String id) throws Exception;
	/**
	 * 查询
	 * 分页查询
	 * @param 角色   属性name模糊查询 ,可不传
	 * @param page 第几页  从1开始
	 * @param pageSize 一页个数
	 * @return
	 * @throws Exception
	 */
	public PageResults<Role> queryRoleListPaged(Role role, Integer page, Integer pageSize)throws Exception;
	/**
	 * 查询全部角色
	 * @return
	 * @throws Exception
	 */
	public PageResults<Role> queryRoleAll()throws Exception;
	
	
}
