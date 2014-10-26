package com.siriussoft.platform.core.unit;

import java.io.Serializable;

/**
 * <pre>
 *	객체의 식별값을 정의한다. 모든 객체의 식별 key는 해당 클래스를 상속 받아서 구현한다.
 * </pre>
 * 
 * @author 허병훈
 * @version 1.0 , 2014.10.25 최초 작성
 */
abstract public class AbstractKey  implements Serializable {
	
    private static final long serialVersionUID = 1L;
	
	public AbstractKey(){
		super();
	}
	
	/**
	 * 키값이 동일한지 비교한다.
	 * @param other
	 * @return
	 */
	abstract public boolean equals(AbstractKey other);
	
	/**
	 * 키가 존재하는지 체크한다.
	 * @return
	 */
	abstract public boolean isExist();
	
	/**
	 * 키값을 문자열로 반환한다.
	 */
	@Override
	abstract public String toString();
}


