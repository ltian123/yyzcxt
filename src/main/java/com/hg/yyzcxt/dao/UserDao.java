package com.hg.yyzcxt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hg.yyzcxt.entity.User;
import com.hg.yyzcxt.utils.MyMapper;

/**
 * 用户数据访问对象
 * @author 
 *
 */
@Repository("userDao")
public interface UserDao  extends MyMapper<User> {
		
}

