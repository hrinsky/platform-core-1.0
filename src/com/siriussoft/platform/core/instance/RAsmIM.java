/**
 * 
 */
package com.siriussoft.platform.core.instance;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.siriussoft.platform.core.exception.InstanceCreateException;
import com.siriussoft.platform.core.exception.Message;

/**
 * <pre>
 *	RAsmIM 방식으로 인스턴스를 생성한다.
 * </pre>
 * 
 * @author 허병훈
 * @version 1.0 , 2014.10.26 최초 작성
 */
public class RAsmIM extends InstanceManager<ConstructorAccess<?>> {
	private static final long serialVersionUID = 1L;
	

	@Override
	public ConstructorAccess<?> put(String className) throws InstanceCreateException {
		ConstructorAccess<?> ca = null;

		try{
			if ((ca = this.get(className)) == null) {
				ca = ConstructorAccess.get(Class.forName(className));
				
				this.put(className, ca);
			}
		}catch(ClassNotFoundException e){
			//TODO : throw exception
			throw new InstanceCreateException(e, new Message("Class 파일를 찾을수 없습니다."));
		}
		
		return ca;
	}
	@Override
	public Object newInstance(String className) throws InstanceCreateException{
		return put(className).newInstance();
	}
}

