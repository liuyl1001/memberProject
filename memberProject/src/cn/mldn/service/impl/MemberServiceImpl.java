package cn.mldn.service.impl;

import java.sql.SQLException;

import cn.mldn.dao.IMemberDao;
import cn.mldn.service.IMemberService;
import cn.mldn.util.factory.Factory;
import cn.mldn.vo.Member;

public class MemberServiceImpl implements IMemberService {

	@Override
	public boolean add(Member vo)  {
		IMemberDao memberDao=Factory.getDaoInstance("member.dao");
		try {
			if(memberDao.findById(vo.getMid())==null){
				vo.setDel(0);//新增的数据是不可能被删除的，因此删除标记为0。
				return memberDao.doCreate(vo);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

}
