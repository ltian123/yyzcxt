package com.hg.yyzcxt.service;



import org.springframework.stereotype.Repository;
import com.hg.yyzcxt.entity.User;
import com.hg.yyzcxt.exception.DuplicateUsernameException;
import com.hg.yyzcxt.exception.UserNotFoundException;
import com.hg.yyzcxt.exception.UserStatusException;
import com.hg.yyzcxt.utils.PageResults;

@Repository("userService")
public interface UserService {
	
	/**
	 * 更新
	 * 根据用户id ，更新用户详情 ，根据主键进行更新，只会更新不是null的数据
	 * @param user 用户 
	 * @return
	 * @throws Exception
	 */
	public int updateUserById(User user) throws Exception;
	/**
	 * 删除
	 * 根据用户id数组，删除批量用户
	 * @param ids 用户id数组
	 * @return
	 * @throws Exception
	 */
	public int removeUsersByids(String[] ids) throws Exception;
	/**
	 * 查询
	 * 根据id查询单个用户详情
	 * @param id  主键id
	 * @return user
	 * @throws UserNotFoundException 用户不存在异常，当用户输入的用户名或密码错误时，抛出此异常
	 */
	public User queryUserOneById(String id) throws UserNotFoundException;
	/**
	 * 查询
	 * 分页查询
	 * @param user 属性username模糊查询
	 * @param page 第几页  从1开始
	 * @param pageSize 一页多少个
	 * @return
	 * @throws Exception
	 */
	public PageResults<User> queryUserListPaged(User user, Integer page, Integer pageSize)throws Exception;
	
	/** 
	 * 插入
	 * 用户注册 ，只插入不为null的字段,不会影响有默认值的字段
	 * @param user 封装了用户注册信息的用户对象
	 * @throws DuplicateUsernameException 重复的用户名异常，当用户注册的用户名在本系统中存在时，抛出此异常
	 * @throws ServiceException 服务失败异常，当此业务操作未成功时，抛出此异常
	 */
	public void regist(User user)throws DuplicateUsernameException;
	
	/**
	 * 查询
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 封装登录用户信息的用户对象
	 * @throws UserNotFoundException 用户不存在异常，当用户输入的用户名或密码错误时，抛出此异常
	 * @throws UserStatusException 用户状态异常，当用户状态为禁用状态时，抛出此异常
	 * @throws ServiceException 服务失败异常，当此业务操作未成功时，抛出此异常
	 */
	public User login(String username,String password)throws UserNotFoundException,UserStatusException;
	/**
	 * 查询
	 * 校验用户名是否已经存在
	 * @param username
	 * @throws DuplicateUsernameException
	 */
	public void validateUsername(String username)throws DuplicateUsernameException;
	
	
}
