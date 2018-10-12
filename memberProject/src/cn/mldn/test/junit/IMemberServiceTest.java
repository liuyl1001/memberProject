package cn.mldn.test.junit;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;
import java.util.Random;

import junit.framework.TestCase;

import org.junit.Test;

import cn.mldn.service.IMemberService;
import cn.mldn.util.factory.Factory;
import cn.mldn.vo.Member;

public class IMemberServiceTest {
	private static int rand=0;
	static{
		rand=new Random().nextInt(9999);
	}
	@Test
	public void testAdd() throws ParseException {
		Member member=new Member();
		member.setMid("PY"+rand);
		member.setName("张三"+rand);
		member.setBirthday(new Date());
		member.setSalary(1.2);
		member.setNote("程鹏民教授");
		member.setDel(0);
		IMemberService memberService = Factory.getServiceInstance("member.service");
		TestCase.assertTrue(memberService.add(member));
	}

}
