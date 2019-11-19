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
import com.hg.yyzcxt.dao.MenuDao;
import com.hg.yyzcxt.dao.UserDao;
import com.hg.yyzcxt.entity.Menu;
import com.hg.yyzcxt.entity.User;
import com.hg.yyzcxt.exception.MenuException;
import com.hg.yyzcxt.exception.UserNotFoundException;
import com.hg.yyzcxt.service.MenuService;
import com.hg.yyzcxt.utils.PageResults;

import tk.mybatis.mapper.entity.Example;
@Service
@Transactional(propagation=Propagation.REQUIRED ,rollbackFor = Exception.class)
public class MenuServiceImpl implements MenuService {

	
	@Autowired
	private MenuDao menuDao; 
	
	@Autowired
	private Sid sid;
	@Override
	public int saveMenu(Menu menu) throws Exception {
		if(menu == null){
			throw new MenuException("添加菜单为空");
		}
		//id
			menu.setId(sid.nextShort());
			if(StringUtil.isNotEmpty(menu.getMenuicon())) {
				//设置默认样式
				menu.setMenuicon(Constant.MENU_DEAULT_MENUICON);
			}
			if(StringUtil.isNotEmpty(menu.getPid())) {
				//设置默认父节点
				menu.setPid(Constant.MENU_DEAULT_PID);
			}
			
			return menuDao.insertSelective(menu);
	}

	@Override
	public int removeMenusByids(String[] ids) throws Exception {
		int ii = 0;
		if(ids.length == 0) {
			throw new MenuException("删除菜单为空");
		}
		 for (int i = 0; i < ids.length; i++) {
			ii = menuDao.deleteByPrimaryKey(ids[i]);
			if(ii == 0) {
				throw new MenuException("删除菜单失败");
			}
        }
		return ii;
	}

	@Override
	public int updateMenuById(Menu menu) throws Exception {
		if(menu == null){
			throw new MenuException("修改菜单为空");
		}
		return menuDao.updateByPrimaryKeySelective(menu);
	}

	@Override
	public Menu queryMenuOneById(String id) throws Exception {
		Menu u = new Menu();
		u.setId(id);
		Menu menu = menuDao.selectOne(u);
		if(menu == null){
			 throw new MenuException("查询菜单不存在");
		}
		return menu;
	}

	@Override
	@Transactional(readOnly=true)
	public PageResults<Menu> queryMenuListPaged(Menu menu, Integer page, Integer pageSize) throws Exception {
		// 开始分页
        PageHelper.startPage(page, pageSize);
		//example
		Example example = new Example(Menu.class);
		Example.Criteria criteria = example.createCriteria();
		//通过name查询
		if(menu != null) {
			if (StringUtil.isNotEmpty(menu.getName())) {
				criteria.andLike("name", "%" + menu.getName() + "%");
			}
		}
		//通过sort排序
		example.setOrderByClause(" sort  ");  
		//查询
		List<Menu> menuList = menuDao.selectByExample(example);
		//分页工具类
		PageResults<Menu> result = new PageResults();
		//PageInfo 
		PageInfo<Menu> p = new PageInfo<Menu>(menuList);
		//result  totalcount  查询总数
		result.setTotalCount((int)p.getTotal());
		result.setResults(menuList);
		return result;
	}

	@Override
	@Transactional(readOnly=true)
	public PageResults<Menu> queryMenuAll() throws Exception {
		List<Menu> menus = menuDao.selectAll();
		//分页工具类
		PageResults<Menu> result = new PageResults();
		//results 结果  totalcount  查询总数
		result.setResults(menus);
		result.setTotalCount(menus.size());
		return result;
	}

}
