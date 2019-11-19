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
import com.hg.yyzcxt.dao.KindDetailDao;
import com.hg.yyzcxt.entity.KindDetail;
import com.hg.yyzcxt.exception.KindDetailException;
import com.hg.yyzcxt.service.KindDetailService;
import com.hg.yyzcxt.utils.PageResults;

import tk.mybatis.mapper.entity.Example;
@Service
@Transactional(propagation=Propagation.REQUIRED ,rollbackFor = Exception.class)
public class KindDetailServiceImpl implements KindDetailService {

	
	@Autowired
	private KindDetailDao kindDetailDao; 
	
	@Autowired
	private Sid sid;
	@Override
	public int saveKindDetail(KindDetail kindDetail) throws Exception {
		if(kindDetail == null){
			throw new KindDetailException("添加数据字典详情为空");
		}
		//id
		kindDetail.setId(sid.nextShort());
		return kindDetailDao.insertSelective(kindDetail);
	}

	@Override
	public int removeKindDetailsByids(String[] ids) throws Exception {
		int ii = 0;
		if(ids.length == 0) {
			throw new KindDetailException("删除数据字典详情为空");
		}
		 for (int i = 0; i < ids.length; i++) {
			ii = kindDetailDao.deleteByPrimaryKey(ids[i]);
			if(ii == 0) {
				throw new KindDetailException("删除数据字典详情失败");
			}
        }
		return ii;
	}

	@Override
	public int updateKindDetailById(KindDetail kindDetail) throws Exception {
		if(kindDetail == null){
			throw new KindDetailException("修改数据字典详情为空");
		}
		return kindDetailDao.updateByPrimaryKeySelective(kindDetail);
	}

	@Override
	public KindDetail queryKindDetailOneById(String id) throws Exception {
		KindDetail u = new KindDetail();
		u.setId(id);
		KindDetail kindDetail = kindDetailDao.selectOne(u);
		if(kindDetail == null){
			 throw new KindDetailException("查询数据字典详情不存在");
		}
		return kindDetail;
	}

	@Override
	@Transactional(readOnly=true)
	public PageResults<KindDetail> queryKindDetailListPaged(KindDetail kindDetail, Integer page, Integer pageSize) throws Exception {
		// 开始分页
        PageHelper.startPage(page, pageSize);
		//example
		Example example = new Example(KindDetail.class);
		Example.Criteria criteria = example.createCriteria();
		//通过name查询
		if(kindDetail != null) {
			if (StringUtil.isNotEmpty(kindDetail.getDetailName())) {
				criteria.andLike("name", "%" + kindDetail.getDetailName() + "%");
			}
		}
		//通过sort排序
		example.setOrderByClause(" sort  ");  
		//查询
		List<KindDetail> kindDetailList = kindDetailDao.selectByExample(example);
		//分页工具类
		PageResults<KindDetail> result = new PageResults();
		//PageInfo 
		PageInfo<KindDetail> p = new PageInfo<KindDetail>(kindDetailList);
		//result  totalcount  查询总数
		result.setTotalCount((int)p.getTotal());
		result.setResults(kindDetailList);
		return result;
	}

	@Override
	@Transactional(readOnly=true)
	public PageResults<KindDetail> queryKindDetailAll() throws Exception {
		List<KindDetail> kindDetails = kindDetailDao.selectAll();
		//分页工具类
		PageResults<KindDetail> result = new PageResults();
		//results 结果  totalcount  查询总数
		result.setResults(kindDetails);
		result.setTotalCount(kindDetails.size());
		return result;
	}

}
