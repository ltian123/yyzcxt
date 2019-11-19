package com.hg.yyzcxt.service;

import org.springframework.stereotype.Repository;
import com.hg.yyzcxt.entity.Actlog;
import com.hg.yyzcxt.utils.PageResults;

@Repository("actlogService")
public interface ActlogService {
	
	/**
	 * 增加
	 * 新增操作日志
	 * @param actlog
	 * @return
	 * @throws Exception
	 */
	public int saveActlog(Actlog actlog) throws Exception;
	/**
	 * 删除
	 * 根据操作日志id数组，删除批量操作日志
	 * @param ids 操作日志id数组
	 * @return
	 * @throws Exception
	 */
	public int removeActlogsByids(String[] ids) throws Exception;
	/**
	 * 更新
	 * 根据操作日志id ，更新操作日志 ，根据主键进行更新，只会更新不是null的数据
	 * @param 操作日志
	 * @return
	 * @throws Exception
	 */
	public int updateActlogById(Actlog actlog) throws Exception;
	
	/**
	 * 查询
	 * 根据id查询单个操作日志
	 * @param id  主键id
	 * @return 操作日志Actlog
	 */
	public Actlog queryActlogOneById(String id) throws Exception;
	/**
	 * 查询
	 * 分页查询
	 * @param 操作日志   属性操作人actUsername模糊查询 ,可不传
	 * @param page 第几页  从1开始
	 * @param pageSize 一页个数
	 * @return
	 * @throws Exception
	 */
	public PageResults<Actlog> queryActlogListPaged(Actlog actlog, Integer page, Integer pageSize)throws Exception;
	/**
	 * 查询全部操作日志
	 * @return
	 * @throws Exception
	 */
	public PageResults<Actlog> queryActlogAll()throws Exception;
	
	
}
