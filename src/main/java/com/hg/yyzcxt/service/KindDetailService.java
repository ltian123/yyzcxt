package com.hg.yyzcxt.service;

import org.springframework.stereotype.Repository;
import com.hg.yyzcxt.entity.KindDetail;
import com.hg.yyzcxt.utils.PageResults;

@Repository("kindDetailService")
public interface KindDetailService {
	
	/**
	 * 增加
	 * 新增数据字典详情
	 * @param kindDetail
	 * @return
	 * @throws Exception
	 */
	public int saveKindDetail(KindDetail kindDetail) throws Exception;
	/**
	 * 删除
	 * 根据数据字典详情id数组，删除批量数据字典详情
	 * @param ids 数据字典详情id数组
	 * @return
	 * @throws Exception
	 */
	public int removeKindDetailsByids(String[] ids) throws Exception;
	/**
	 * 更新
	 * 根据数据字典详情id ，更新数据字典详情详情 ，根据主键进行更新，只会更新不是null的数据
	 * @param 数据字典详情
	 * @return
	 * @throws Exception
	 */
	public int updateKindDetailById(KindDetail kindDetail) throws Exception;
	
	/**
	 * 查询
	 * 根据id查询单个数据字典详情详情
	 * @param id  主键id
	 * @return 数据字典详情KindDetail
	 */
	public KindDetail queryKindDetailOneById(String id) throws Exception;
	/**
	 * 查询
	 * 分页查询
	 * @param 数据字典详情   属性name模糊查询 ,可不传
	 * @param page 第几页  从1开始
	 * @param pageSize 一页个数
	 * @return
	 * @throws Exception
	 */
	public PageResults<KindDetail> queryKindDetailListPaged(KindDetail kindDetail, Integer page, Integer pageSize)throws Exception;
	/**
	 * 查询全部数据字典详情
	 * @return
	 * @throws Exception
	 */
	public PageResults<KindDetail> queryKindDetailAll()throws Exception;
	
	
}
