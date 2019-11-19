package com.hg.yyzcxt.service.impl;

import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.hg.yyzcxt.constant.Constant;
import com.hg.yyzcxt.dao.RoleDao;
import com.hg.yyzcxt.dao.UserRoleMapDao;
import com.hg.yyzcxt.entity.Role;
import com.hg.yyzcxt.entity.UserRoleMap;
import com.hg.yyzcxt.exception.RoleException;
import com.hg.yyzcxt.service.RoleService;
import com.hg.yyzcxt.utils.PageResults;

import tk.mybatis.mapper.entity.Example;
@Service
@Transactional(propagation=Propagation.REQUIRED ,rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

	
	@Autowired
	private RoleDao roleDao; 
	
	@Autowired
	private UserRoleMapDao userRoleMapDao; 
	
	@Autowired
	private Sid sid;
	@Override
	public int saveRole(Role role) throws Exception {
		if(role == null){
			throw new RoleException("添加角色为空");
		}
		//id
		role.setId(sid.nextShort());
		return roleDao.insertSelective(role);
	}

	@Override
	public int removeRolesByids(String[] ids) throws Exception {
		int ii = 0;
		if(ids.length == 0) {
			throw new RoleException("删除角色为空");
		}
		 for (int i = 0; i < ids.length; i++) {
			ii = roleDao.deleteByPrimaryKey(ids[i]);
			UserRoleMap urm = new UserRoleMap();
			urm.setRoleId(ids[i]);
			userRoleMapDao.delete(urm);
			if(ii == 0) {
				throw new RoleException("删除角色失败");
			}
        }
		return ii;
	}

	@Override
	public int updateRoleById(Role role) throws Exception {
		if(role == null){
			throw new RoleException("修改角色为空");
		}
		return roleDao.updateByPrimaryKeySelective(role);
	}

	@Override
	public Role queryRoleOneById(String id) throws Exception {
		Role u = new Role();
		u.setId(id);
		Role role = roleDao.selectOne(u);
		if(role == null){
			 throw new RoleException("查询角色不存在");
		}
		return role;
	}

	@Override
	@Transactional(readOnly=true)
	public PageResults<Role> queryRoleListPaged(Role role, Integer page, Integer pageSize) throws Exception {
		// 开始分页
        PageHelper.startPage(page, pageSize);
		//example
		Example example = new Example(Role.class);
		Example.Criteria criteria = example.createCriteria();
		//通过name查询
		if(role != null) {
			if (StringUtil.isNotEmpty(role.getName())) {
				criteria.andLike("name", "%" + role.getName() + "%");
			}
		}
		//通过sort排序
		example.setOrderByClause(" sort  ");  
		//查询
		List<Role> roleList = roleDao.selectByExample(example);
		//分页工具类
		PageResults<Role> result = new PageResults();
		//PageInfo 
		PageInfo<Role> p = new PageInfo<Role>(roleList);
		//result  totalcount  查询总数
		result.setTotalCount((int)p.getTotal());
		result.setResults(roleList);
		return result;
	}

	@Override
	@Transactional(readOnly=true)
	public PageResults<Role> queryRoleAll() throws Exception {
		List<Role> roles = roleDao.selectAll();
		//分页工具类
		PageResults<Role> result = new PageResults();
		//results 结果  totalcount  查询总数
		result.setResults(roles);
		result.setTotalCount(roles.size());
		return result;
	}

}
