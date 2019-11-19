package com.hg.yyzcxt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hg.yyzcxt.entity.Menu;
import com.hg.yyzcxt.entity.Role;
import com.hg.yyzcxt.utils.MyMapper;

/**
 * 用户数据访问对象
 * @author 
 *
 */
@Repository("roleDao")
public interface RoleDao  extends MyMapper<Role> {
		
}

