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
import com.hg.yyzcxt.dao.KindDao;
import com.hg.yyzcxt.entity.Kind;
import com.hg.yyzcxt.exception.KindException;
import com.hg.yyzcxt.service.KindService;
import com.hg.yyzcxt.utils.PageResults;

import tk.mybatis.mapper.entity.Example;
@Service
@Transactional(propagation=Propagation.REQUIRED ,rollbackFor = Exception.class)
public class KindServiceImpl implements KindService {

	
	@Autowired
	private KindDao kindDao; 
	
	@Autowired
	private Sid sid;
	@Override
	public int saveKind(Kind kind) throws Exception {
		if(kind == null){
			throw new KindException("添加数据字典为空");
		}
		//id
		kind.setId(sid.nextShort());
		return kindDao.insertSelective(kind);
	}

	@Override
	public int removeKindsByids(String[] ids) throws Exception {
		int ii = 0;
		if(ids.length == 0) {
			throw new KindException("删除数据字典为空");
		}
		 for (int i = 0; i < ids.length; i++) {
			ii = kindDao.deleteByPrimaryKey(ids[i]);
			if(ii == 0) {
				throw new KindException("删除数据字典失败");
			}
        }
		return ii;
	}

	@Override
	public int updateKindById(Kind kind) throws Exception {
		if(kind == null){
			throw new KindException("修改数据字典为空");
		}
		return kindDao.updateByPrimaryKeySelective(kind);
	}

	@Override
	public Kind queryKindOneById(String id) throws Exception {
		Kind u = new Kind();
		u.setId(id);
		Kind kind = kindDao.selectOne(u);
		if(kind == null){
			 throw new KindException("查询数据字典不存在");
		}
		return kind;
	}

	@Override
	@Transactional(readOnly=true)
	public PageResults<Kind> queryKindListPaged(Kind kind, Integer page, Integer pageSize) throws Exception {
		// 开始分页
        PageHelper.startPage(page, pageSize);
		//example
		Example example = new Example(Kind.class);
		Example.Criteria criteria = example.createCriteria();
		//通过name查询
		if(kind != null) {
			if (StringUtil.isNotEmpty(kind.getName())) {
				criteria.andLike("name", "%" + kind.getName() + "%");
			}
		}
		//通过sort排序
		example.setOrderByClause(" sort  ");  
		//查询
		List<Kind> kindList = kindDao.selectByExample(example);
		//分页工具类
		PageResults<Kind> result = new PageResults();
		//PageInfo 
		PageInfo<Kind> p = new PageInfo<Kind>(kindList);
		//result  totalcount  查询总数
		result.setTotalCount((int)p.getTotal());
		result.setResults(kindList);
		return result;
	}

	@Override
	@Transactional(readOnly=true)
	public PageResults<Kind> queryKindAll() throws Exception {
		List<Kind> kinds = kindDao.selectAll();
		//分页工具类
		PageResults<Kind> result = new PageResults();
		//results 结果  totalcount  查询总数
		result.setResults(kinds);
		result.setTotalCount(kinds.size());
		return result;
	}

}
