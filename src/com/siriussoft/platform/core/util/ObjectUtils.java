package com.siriussoft.platform.core.util;

import java.util.List;

import com.siriussoft.platform.core.unit.AbstractKey;
import com.siriussoft.platform.core.unit.AbstractModel;
import com.siriussoft.platform.core.unit.AbstractModels;

/**
 * <pre>
 *	 객체에 대한 Null, 공백 여부를 체크한다.
 * </pre>
 * 
 * @author 허병훈
 * @version 1.0 , 2014.10.25 최초 작성
 */
public class ObjectUtils {

	/**
	 * 입력한 리스트에 객체가 존재하는지 확인한다.
	 * @param list 
	 * @return 존재하면 false를 반환한다.
	 */
	public static boolean isNone(List<? extends AbstractModel> list){
		return list == null || list.size() == 0;
	}
	
	/**
	 * 입력한 객체가 존재하는지 확인한다.
	 * @param model
	 * @return 존재하면 false를 반환한다.
	 */
	public static boolean isNone(AbstractModel model){
		return model == null || !model.isExist();
	}
	
	/**
	 * 입력한 객체들이 존재하는지 확인한다.
	 * @param models 
	 * @return 존재하면 false를 반환한다.
	 */
	public static boolean isNone(AbstractModels models){
		return models == null || !models.isExist();
	}
	
	/**
	 * 입력한 객체 식별자가 존재하는지 확인한다.
	 * @param key 객체 식별자
	 * @return 존재하면 false를 반환한다.
	 */
	public static boolean isNone(AbstractKey key){
		return key == null || !key.isExist();
	}
	
	/**
	 * 문자열이 null 이면서, 공백이지 확인한다.
	 * @param str 문자열 
	 * @return null 이면서, 공백이면 true를 반환한다.
	 */
	public static boolean isNone(String str){
		return str == null || str.trim().equals("");
	}
	
}
