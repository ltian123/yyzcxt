package com.hg.yyzcxt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.UpdateProvider;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hg.yyzcxt.service.UserService;
import com.hg.yyzcxt.utils.MD5Util;
import com.hg.yyzcxt.utils.PageResults;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.hg.yyzcxt.constant.Constant;
import com.hg.yyzcxt.dao.UserDao;
import com.hg.yyzcxt.dao.UserRoleMapDao;
import com.hg.yyzcxt.entity.User;
import com.hg.yyzcxt.entity.UserRoleMap;
import com.hg.yyzcxt.exception.DuplicateUsernameException;
import com.hg.yyzcxt.exception.UserNotFoundException;
import com.hg.yyzcxt.exception.UserStatusException;

@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao; 
	
	@Autowired
	private UserRoleMapDao userRoleMapDao; 
	
	@Autowired
	private Sid sid;

    @Override
    @Transactional(readOnly=true)
	public PageResults<User> queryUserListPaged(User user, Integer page, Integer pageSize) {
		// 开始分页
        PageHelper.startPage(page, pageSize);
		//example
		Example example = new Example(User.class);
		Example.Criteria criteria = example.createCriteria();
		//通过username查询
		if(user != null) {
			if (StringUtil.isNotEmpty(user.getUsername())) {
				criteria.andLike("username", "%" + user.getUsername() + "%");
			}
		}
		//通过sort排序
		example.setOrderByClause(" sort  ");  
		//查询
		List<User> userList = userDao.selectByExample(example);
		//分页工具类
		PageResults<User> result = new PageResults();
		//PageInfo 
		PageInfo<User> p = new PageInfo<User>(userList);
		//result  totalcount  查询总数
		result.setTotalCount((int)p.getTotal());
		result.setResults(userList);
		return result;
	}
    
    public void regist(User user) throws DuplicateUsernameException {
    	User queryUser = new User();
    	queryUser.setUsername(user.getUsername());
		User u = userDao.selectOne(queryUser);
		if(u != null){
			throw new DuplicateUsernameException("用户名已存在");
		}
		user.setId(sid.nextShort());
		user.setPassword(MD5Util.md5(user.getPassword()));
		user.setStatus(Constant.USER_STATUS_ENABLE);
		user.setCreateDate(new Date());
		userDao.insertSelective(user);
	}

	@Transactional(readOnly = true)
	public User login(String username, String password)throws UserNotFoundException, UserStatusException {
		User u = new User();
		u.setUsername(username);
		u.setPassword(MD5Util.md5(password));
		User user=userDao.selectOne(u);
		if(user==null){
			throw new UserNotFoundException("用户名或密码错误");
		}
		if(Constant.USER_STATUS_DISABLE.equals(user.getStatus())){
			throw new UserStatusException("用户已被禁用");
		}
		return user;
	}

	@Transactional(readOnly = true)
	public void validateUsername(String username)throws DuplicateUsernameException {
		User u = new User();
		u.setUsername(username);
		int count = userDao.selectCount(u);
		if(count > 0){
			throw new DuplicateUsernameException("用户名已存在");
		}
	}

	@Override
	public int updateUserById(User user) throws Exception {
		return userDao.updateByPrimaryKeySelective(user);
	}

	@Override
	public int removeUsersByids(String[] ids) throws Exception {
		int ii = 0;
		 for (int i = 0; i < ids.length; i++) {
			ii = userDao.deleteByPrimaryKey(ids[i]);
			UserRoleMap urm = new UserRoleMap();
			urm.setUserId(ids[i]);
			ii = userRoleMapDao.delete(urm);
         }
		return ii;
	}

	@Override
	public User queryUserOneById(String id) throws UserNotFoundException {
		User u = new User();
		u.setId(id);
		User user = userDao.selectOne(u);
		if(user==null){
			throw new UserNotFoundException("用户不存在");
		}
		return user;
	}
}
