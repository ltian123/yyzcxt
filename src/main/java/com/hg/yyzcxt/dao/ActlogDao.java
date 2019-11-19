package com.hg.yyzcxt.dao;


import org.springframework.stereotype.Repository;

import com.hg.yyzcxt.entity.Actlog;
import com.hg.yyzcxt.utils.MyMapper;

/**
 * 用户数据访问对象
 * @author 
 *
 */
@Repository("actlogDao")
public interface ActlogDao  extends MyMapper<Actlog> {
		
}

