package cn.mldn.util.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;



import cn.mldn.util.dbc.DatabaseConnection;

public class ServiceProxy {
	//设计一个Object变量记住代理类要代理的目标对象
	private Object disObject = null;
	public Object bind(Object target){
		this.disObject=target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				Object retObject = null;
				System.out.println( method.getName());
				if ( method.getName().equals("add") || method.getName().equals("edit")||method.getName().equals("delete")) {
					DatabaseConnection.getConnection().setAutoCommit(false);
					//代理对象执行目标对象的实际方法
					try {
						retObject=method.invoke(disObject, args);
						
						DatabaseConnection.getConnection().commit();
					} catch (Exception e) {
						e.printStackTrace();
						DatabaseConnection.getConnection().rollback();
					}finally{
						DatabaseConnection.getConnection().close();
					}
				}else {
					try {
						retObject=method.invoke(disObject, args);
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DatabaseConnection.getConnection().close();
					}			
				}
				System.out.println(DatabaseConnection.getConnection());
				return retObject;
			}
		});
	}
	
}
