package cn.mldn.service;

import cn.mldn.vo.Member;

public interface IMemberService {
	/**
	 *本业务需要实现以下功能：
	 *1、通过IMemberDao.findByID判断member是否存在。
	 *2、如果member不存在调用IMemberDao.doCreate方法创建该对象
	 * @param vo
	 * @return boolean
	 */
	public boolean add(Member vo) ;

}
