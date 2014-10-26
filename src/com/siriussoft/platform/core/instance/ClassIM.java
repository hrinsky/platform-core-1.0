/**
 * 
 */
package com.siriussoft.platform.core.instance;

import com.siriussoft.platform.core.exception.InstanceCreateException;
import com.siriussoft.platform.core.exception.Message;

/**
 * <pre>
 *	ClassIM 방식으로 인스턴스를 생성한다.
 * </pre>
 * 
 * @author 허병훈
 * @version 1.0 , 2014.10.26 최초 작성
 */
public class ClassIM extends InstanceManager<Class<?>> {
	private static final long serialVersionUID = 1L;
	
	@Override
	public Class<?> put(String className) throws InstanceCreateException {
		Class<?> c = null;
		try{

			if ((c = this.get(className)) == null) {
				c = Class.forName(className);
				this.put(className, c);
			}
		}catch(ClassNotFoundException e){
			//TODO : throw exception
			throw new InstanceCreateException(e, new Message("Class 파일를 찾을수 없습니다."));
		}
		return c;
	}
	@Override
	public Object newInstance(String className) throws InstanceCreateException {
		Object obj = null;
		try {
			obj = put(className).newInstance();
		}catch (InstantiationException e) {
			//TODO : throw exception
			throw new InstanceCreateException(e, new Message("ClassIM 방식으로 인스턴스 생성중 오류가 발생 했습니다."));
		} catch (IllegalAccessException e) {
			//TODO : throw exception
			throw new InstanceCreateException(e, new Message("접근 권한이 존재하지 않습니다."));
		}
		return obj;
	}
}

