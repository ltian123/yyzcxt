package com.hg.yyzcxt.dao;


import org.springframework.stereotype.Repository;

import com.hg.yyzcxt.entity.Kind;
import com.hg.yyzcxt.utils.MyMapper;

/**
 * 用户数据访问对象
 * @author 
 *
 */
@Repository("kindDao")
public interface KindDao  extends MyMapper<Kind> {
		
}

