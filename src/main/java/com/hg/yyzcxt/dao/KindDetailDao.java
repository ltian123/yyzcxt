package com.hg.yyzcxt.dao;


import org.springframework.stereotype.Repository;

import com.hg.yyzcxt.entity.KindDetail;
import com.hg.yyzcxt.utils.MyMapper;

/**
 * 用户数据访问对象
 * @author 
 *
 */
@Repository("kindDetailDao")
public interface KindDetailDao  extends MyMapper<KindDetail> {
		
}

