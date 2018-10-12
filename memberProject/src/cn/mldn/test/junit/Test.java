package cn.mldn.test.junit;

import java.util.Date;

import cn.mldn.service.IMemberService;
import cn.mldn.util.factory.Factory;
import cn.mldn.vo.Member;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IMemberService memberService = Factory.getServiceInstance("member.service");
		Member member=new Member();
		member.setMid("PY");
		member.setName("张三");
		member.setBirthday(new Date());
		member.setSalary(1.1);
		member.setNote("教授");
		member.setDel(0);
		memberService.add(member);
	}

}
