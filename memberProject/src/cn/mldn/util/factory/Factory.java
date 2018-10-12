package cn.mldn.util.factory;

import cn.mldn.util.MessageUtil;
import cn.mldn.util.proxy.ServiceProxy;

public class Factory {
	private static final MessageUtil DAO_MESSAGE =
			new MessageUtil("cn.mldn.util.message.dao");
	private  static final MessageUtil SERVICE_MESSAGE = 
			new MessageUtil("cn.mldn.util.message.service");
	@SuppressWarnings("unchecked")
	public static <T> T  getDaoInstance(String basename){
		String classname=DAO_MESSAGE.getText(basename);
		T t = null;
		try {
			t=(T) Class.forName(classname).newInstance();		
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		return t;	
	}
	@SuppressWarnings("unchecked")
	public static  <T> T getServiceInstance(String basename){
		String classname= SERVICE_MESSAGE.getText(basename);
		T t = null;
		try {
			t= (T) new ServiceProxy().bind(Class.forName(classname).newInstance());
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		return t;
	}
}
