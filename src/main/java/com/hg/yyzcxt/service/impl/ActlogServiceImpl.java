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
import com.hg.yyzcxt.dao.ActlogDao;
import com.hg.yyzcxt.entity.Actlog;
import com.hg.yyzcxt.exception.ActlogException;
import com.hg.yyzcxt.service.ActlogService;
import com.hg.yyzcxt.utils.PageResults;

import tk.mybatis.mapper.entity.Example;
@Service
@Transactional(propagation=Propagation.REQUIRED ,rollbackFor = Exception.class)
public class ActlogServiceImpl implements ActlogService {

	
	@Autowired
	private ActlogDao actlogDao; 
	
	@Autowired
	private Sid sid;
	@Override
	public int saveActlog(Actlog actlog) throws Exception {
		if(actlog == null){
			throw new ActlogException("添加操作日志为空");
		}
		//id
		actlog.setId(sid.nextShort());
		return actlogDao.insertSelective(actlog);
	}

	@Override
	public int removeActlogsByids(String[] ids) throws Exception {
		int ii = 0;
		if(ids.length == 0) {
			throw new ActlogException("删除操作日志为空");
		}
		 for (int i = 0; i < ids.length; i++) {
			ii = actlogDao.deleteByPrimaryKey(ids[i]);
			if(ii == 0) {
				throw new ActlogException("删除操作日志失败");
			}
        }
		return ii;
	}

	@Override
	public int updateActlogById(Actlog actlog) throws Exception {
		if(actlog == null){
			throw new ActlogException("修改操作日志为空");
		}
		return actlogDao.updateByPrimaryKeySelective(actlog);
	}

	@Override
	public Actlog queryActlogOneById(String id) throws Exception {
		Actlog u = new Actlog();
		u.setId(id);
		Actlog actlog = actlogDao.selectOne(u);
		if(actlog == null){
			 throw new ActlogException("查询操作日志不存在");
		}
		return actlog;
	}

	@Override
	@Transactional(readOnly=true)
	public PageResults<Actlog> queryActlogListPaged(Actlog actlog, Integer page, Integer pageSize) throws Exception {
		// 开始分页
        PageHelper.startPage(page, pageSize);
		//example
		Example example = new Example(Actlog.class);
		Example.Criteria criteria = example.createCriteria();
		//通过name查询
		if(actlog != null) {
			if (StringUtil.isNotEmpty(actlog.getActUsername())) {
				criteria.andLike("name", "%" + actlog.getActUsername() + "%");
			}
		}
		//通过sort排序
		example.setOrderByClause(" sort  ");  
		//查询
		List<Actlog> actlogList = actlogDao.selectByExample(example);
		//分页工具类
		PageResults<Actlog> result = new PageResults();
		//PageInfo 
		PageInfo<Actlog> p = new PageInfo<Actlog>(actlogList);
		//result  totalcount  查询总数
		result.setTotalCount((int)p.getTotal());
		result.setResults(actlogList);
		return result;
	}

	@Override
	@Transactional(readOnly=true)
	public PageResults<Actlog> queryActlogAll() throws Exception {
		List<Actlog> actlogs = actlogDao.selectAll();
		//分页工具类
		PageResults<Actlog> result = new PageResults();
		//results 结果  totalcount  查询总数
		result.setResults(actlogs);
		result.setTotalCount(actlogs.size());
		return result;
	}

}
