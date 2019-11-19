package com.hg.yyzcxt.service;

import org.springframework.stereotype.Repository;
import com.hg.yyzcxt.entity.Kind;
import com.hg.yyzcxt.utils.PageResults;

@Repository("kindService")
public interface KindService {
	
	/**
	 * 增加
	 * 新增数据字典
	 * @param kind
	 * @return
	 * @throws Exception
	 */
	public int saveKind(Kind kind) throws Exception;
	/**
	 * 删除
	 * 根据数据字典id数组，删除批量数据字典
	 * @param ids 数据字典id数组
	 * @return
	 * @throws Exception
	 */
	public int removeKindsByids(String[] ids) throws Exception;
	/**
	 * 更新
	 * 根据数据字典id ，更新数据字典详情 ，根据主键进行更新，只会更新不是null的数据
	 * @param 数据字典
	 * @return
	 * @throws Exception
	 */
	public int updateKindById(Kind kind) throws Exception;
	
	/**
	 * 查询
	 * 根据id查询单个数据字典详情
	 * @param id  主键id
	 * @return 数据字典Kind
	 */
	public Kind queryKindOneById(String id) throws Exception;
	/**
	 * 查询
	 * 分页查询
	 * @param 数据字典   属性name模糊查询 ,可不传
	 * @param page 第几页  从1开始
	 * @param pageSize 一页个数
	 * @return
	 * @throws Exception
	 */
	public PageResults<Kind> queryKindListPaged(Kind kind, Integer page, Integer pageSize)throws Exception;
	/**
	 * 查询全部数据字典
	 * @return
	 * @throws Exception
	 */
	public PageResults<Kind> queryKindAll()throws Exception;
	
	
}
