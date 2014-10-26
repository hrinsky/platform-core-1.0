/**
 * 
 */
package com.siriussoft.platform.core.instance;

import java.util.HashMap;

import com.siriussoft.platform.core.exception.InstanceCreateException;

/**
 * <pre>
 *	 Instance 생성를 관리하는 기능을 정의한다. 
 * </pre>
 * 
 * @author 허병훈
 * @version 1.0 , 2014.10.26 최초 작성
 */
public abstract class InstanceManager<T> extends HashMap<String, T> {
	private static final long serialVersionUID = 1L;

	/**
	 * Class 이름을 입력한다.
	 * @param className 생성할 클래스 이름
	 * @return 
	 * @throws InstanceCreateException 클래스를 찾을수 없을 경우
	 */
	abstract public T put(String className) throws InstanceCreateException;
	
	/**
	 * 인스턴스를 생성한다.
	 * @param className 생성할 클래스 이름
	 * @return 생성한 인스턴스
	 * @throws InstanceCreateException 접근권한이 없거나, 인스턴스 생성시 오류가 발생한 경우
	 */
	abstract public Object newInstance(String className) throws InstanceCreateException;
}
