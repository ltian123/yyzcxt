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
import com.hg.yyzcxt.dao.RoleMenuMapDao;
import com.hg.yyzcxt.entity.Menu;
import com.hg.yyzcxt.entity.RoleMenuMap;
import com.hg.yyzcxt.exception.RoleMenuMapException;
import com.hg.yyzcxt.service.RoleMenuMapService;
import com.hg.yyzcxt.utils.PageResults;

import tk.mybatis.mapper.entity.Example;
@Service
@Transactional(propagation=Propagation.REQUIRED ,rollbackFor = Exception.class)
public class RoleMenuMapServiceImpl implements RoleMenuMapService {

	
	@Autowired
	private RoleMenuMapDao roleMenuMapDao; 
	
	@Autowired
	private Sid sid;
	@Override
	public int saveRoleMenuMap(RoleMenuMap roleMenuMap) throws Exception {
		if(roleMenuMap == null){
			throw new RoleMenuMapException("添加角色菜单关系映射为空");
		}
		//id
		roleMenuMap.setId(sid.nextShort());
		return roleMenuMapDao.insertSelective(roleMenuMap);
	}

	@Override
	public int removeRoleMenuMapsByids(String[] ids) throws Exception {
		int ii = 0;
		if(ids.length == 0) {
			throw new RoleMenuMapException("删除角色菜单关系映射为空");
		}
		 for (int i = 0; i < ids.length; i++) {
			ii = roleMenuMapDao.deleteByPrimaryKey(ids[i]);
			if(ii == 0) {
				throw new RoleMenuMapException("删除角色菜单关系映射失败");
			}
        }
		return ii;
	}

	@Override
	public int updateRoleMenuMapById(RoleMenuMap roleMenuMap) throws Exception {
		if(roleMenuMap == null){
			throw new RoleMenuMapException("修改角色菜单关系映射为空");
		}
		return roleMenuMapDao.updateByPrimaryKeySelective(roleMenuMap);
	}

	@Override
	public RoleMenuMap queryRoleMenuMapOneById(String id) throws Exception {
		RoleMenuMap u = new RoleMenuMap();
		u.setId(id);
		RoleMenuMap roleMenuMap = roleMenuMapDao.selectOne(u);
		if(roleMenuMap == null){
			 throw new RoleMenuMapException("查询角色菜单关系映射不存在");
		}
		return roleMenuMap;
	}

	@Override
	@Transactional(readOnly=true)
	public PageResults<RoleMenuMap> queryRoleMenuMapListPaged( Integer page, Integer pageSize) throws Exception {
		// 开始分页
        PageHelper.startPage(page, pageSize);
		//example
		Example example = new Example(RoleMenuMap.class);
		Example.Criteria criteria = example.createCriteria();
		//通过sort排序
		example.setOrderByClause(" sort  ");  
		//查询
		List<RoleMenuMap> roleMenuMapList = roleMenuMapDao.selectByExample(example);
		//分页工具类
		PageResults<RoleMenuMap> result = new PageResults();
		//PageInfo 
		PageInfo<RoleMenuMap> p = new PageInfo<RoleMenuMap>(roleMenuMapList);
		//result  totalcount  查询总数
		result.setTotalCount((int)p.getTotal());
		result.setResults(roleMenuMapList);
		return result;
	}

	@Override
	@Transactional(readOnly=true)
	public PageResults<RoleMenuMap> queryRoleMenuMapAll() throws Exception {
		List<RoleMenuMap> roleMenuMaps = roleMenuMapDao.selectAll();
		//分页工具类
		PageResults<RoleMenuMap> result = new PageResults();
		//results 结果  totalcount  查询总数
		result.setResults(roleMenuMaps);
		result.setTotalCount(roleMenuMaps.size());
		return result;
	}

	@Override
	public List<Menu> queryAllMenusbyRoleId(String roleId) {
		Map<String, Object> map = new HashMap<String, Object>();
    	map.put("roleId", roleId);
    	List<Menu> menus = roleMenuMapDao.selectMenusbyRoleId(map);
		return menus;
	}
	
	public List<Menu> queryAllMenusbyUserId(String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
    	map.put("userId", userId);
    	List<Menu> menus = roleMenuMapDao.selectAllMenusbyUserId(map);
		return menus;
	}

	@Override
	public RoleMenuMap queryRoleMenuMapbyUserIdandMenuId(String menuId,String userId){
		Map<String, Object> map = new HashMap<String, Object>();
    	map.put("menuId", menuId);
    	map.put("userId", userId);
    	RoleMenuMap rmm = roleMenuMapDao.selectRoleMenuMapbyUserIdandRoleId(map);
		return rmm;
	}


}
