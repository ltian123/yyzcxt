package com.hg.yyzcxt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hg.yyzcxt.dao.UserRoleMapDao;
import com.hg.yyzcxt.entity.Role;
import com.hg.yyzcxt.entity.User;
import com.hg.yyzcxt.entity.UserRoleMap;
import com.hg.yyzcxt.exception.UserRoleMapException;
import com.hg.yyzcxt.service.UserRoleMapService;
import com.hg.yyzcxt.utils.PageBean;
import com.hg.yyzcxt.utils.PageResults;

import tk.mybatis.mapper.entity.Example;
@Service
@Transactional(propagation=Propagation.REQUIRED ,rollbackFor = Exception.class)
public class UserRoleMapServiceImpl implements UserRoleMapService {

	
	@Autowired
	private UserRoleMapDao userRoleMapDao; 
	
	@Autowired
	private Sid sid;
	@Override
	public int saveUserRoleMap(UserRoleMap userRoleMap) throws Exception {
		if(userRoleMap == null){
			throw new UserRoleMapException("添加用户角色关系映射为空");
		}
		//判断是否已存在
		int count = userRoleMapDao.selectCount(new UserRoleMap(userRoleMap.getUserId(),userRoleMap.getRoleId()));
		if(count > 0) {
			throw new UserRoleMapException("用户角色关系已存在");
		}
		//id
		userRoleMap.setId(sid.nextShort());
		return userRoleMapDao.insertSelective(userRoleMap);
	}
	@Override
	public int removeUserRoleMapsByuserIdAndRoleId(String userId,String roleId) throws Exception{
		int ii = 0;
		UserRoleMap urm = new UserRoleMap();
		urm.setUserId(userId);
		urm.setRoleId(roleId);
		ii = userRoleMapDao.delete(urm);
//		if(ii <= 0) {
//			throw new UserRoleMapException("删除用户角色关系映射失败");
//		}
		return ii;
	}

	@Override
	public int removeUserRoleMapsByuserid(String userId) throws Exception {
		int ii = 0;
		UserRoleMap urm = new UserRoleMap();
		urm.setUserId(userId);
		ii = userRoleMapDao.delete(urm);
//		if(ii <= 0) {
//			throw new UserRoleMapException("删除用户角色关系映射失败");
//		}
		return ii;
	}
	
	@Override
	public int removeUserRoleMapsByroleid(String roleId) throws Exception {
		int ii = 0;
		UserRoleMap urm = new UserRoleMap();
		urm.setRoleId(roleId);
		ii = userRoleMapDao.delete(urm);
//		if(ii <= 0) {
//			throw new UserRoleMapException("删除用户角色关系映射失败");
//		}
		return ii;
	}
	
	@Override
	public int removeUserRoleMapsByids(String[] ids) throws Exception {
		int ii = 0;
		if(ids.length == 0) {
			throw new UserRoleMapException("删除用户角色关系映射为空");
		}
		 for (int i = 0; i < ids.length; i++) {
			ii = userRoleMapDao.deleteByPrimaryKey(ids[i]);
			if(ii == 0) {
				throw new UserRoleMapException("删除用户角色关系映射失败");
			}
        }
		return ii;
	}

	@Override
	public int updateUserRoleMapById(UserRoleMap userRoleMap) throws Exception {
		if(userRoleMap == null){
			throw new UserRoleMapException("修改用户角色关系映射为空");
		}
		return userRoleMapDao.updateByPrimaryKeySelective(userRoleMap);
	}

	@Override
	public UserRoleMap queryUserRoleMapOneById(String id) throws Exception {
		UserRoleMap u = new UserRoleMap();
		u.setId(id);
		UserRoleMap userRoleMap = userRoleMapDao.selectOne(u);
		if(userRoleMap == null){
			 throw new UserRoleMapException("查询用户角色关系映射不存在");
		}
		return userRoleMap;
	}

	@Override
	@Transactional(readOnly=true)
	public PageResults<UserRoleMap> queryUserRoleMapListPaged( Integer page, Integer pageSize) throws Exception {
		// 开始分页
        PageHelper.startPage(page, pageSize);
		//example
		Example example = new Example(UserRoleMap.class);
		Example.Criteria criteria = example.createCriteria();
		//通过sort排序
		example.setOrderByClause(" sort  ");  
		//查询
		List<UserRoleMap> userRoleMapList = userRoleMapDao.selectByExample(example);
		//分页工具类
		PageResults<UserRoleMap> result = new PageResults();
		//PageInfo 
		PageInfo<UserRoleMap> p = new PageInfo<UserRoleMap>(userRoleMapList);
		//result  totalcount  查询总数
		result.setTotalCount((int)p.getTotal());
		result.setResults(userRoleMapList);
		return result;
	}

	@Override
	@Transactional(readOnly=true)
	public PageResults<UserRoleMap> queryUserRoleMapAll() throws Exception {
		List<UserRoleMap> userRoleMaps = userRoleMapDao.selectAll();
		//分页工具类
		PageResults<UserRoleMap> result = new PageResults();
		//results 结果  totalcount  查询总数
		result.setResults(userRoleMaps);
		result.setTotalCount(userRoleMaps.size());
		return result;
	}

	@Override
	public PageResults<User> queryUsersbyRoleId(String roleId,Integer page, Integer pageSize) throws Exception {
		//分页工具类
		PageResults<User> result = new PageResults<User>();
		PageBean pagebean = new PageBean(page, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
    	map.put("roleId", roleId);
    	map.put("start", pagebean.getStart());
    	map.put("end", pagebean.getEnd());
		List<User> users = userRoleMapDao.selectUsersbyRoleId(map);
		int count = userRoleMapDao.countUsersbyRoleId(roleId);
		result.setPageSize(count);
		result.setResults(users);
		return result;
	}

	@Override
	public PageResults<Role> queryRoleByUserId(String userId,Integer page, Integer pageSize) throws Exception {
		//分页工具类
		PageResults<Role> result = new PageResults<Role>();
		PageBean pagebean = new PageBean(page, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
    	map.put("userId", userId);
    	map.put("start", pagebean.getStart());
    	map.put("end", pagebean.getEnd());
		List<Role> roles = userRoleMapDao.selectRoleByUserId(map);
		int count = userRoleMapDao.countRolesByUserId(userId);
		result.setPageSize(count);
		result.setResults(roles);
		return result;
	}

}
