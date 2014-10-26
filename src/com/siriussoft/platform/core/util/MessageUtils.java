/**
 * 
 */
package com.siriussoft.platform.core.util;

import java.util.ArrayList;
import java.util.List;

import com.siriussoft.platform.core.exception.CanNotFindMessageException;
import com.siriussoft.platform.core.exception.MessagePropertiesLoadingException;
import com.siriussoft.platform.core.message.CodeMessage;
import com.siriussoft.platform.core.message.CommonMessage;
import com.siriussoft.platform.core.message.ErrorMessage;
import com.siriussoft.platform.core.message.FieldMessage;

/**
 * <pre>
 *	 Message를 가져오는 기능에 대해서 정의한다.
 * </pre>
 * 
 * @author 허병훈
 * @version 1.0 , 2014.10.26 최초 작성
 */
public class MessageUtils {

	public static String MESSAGE_COMMON = "common";                  //일반 메시지 사용
	public static String MESSAGE_ERROR = "error";								//에러 메시지 사용
	public static String MESSAGE_CODE = "code";									//코드 메시지 사용
	public static String MESSAGE_FIELD= "field";										//화면필드 메시지 사용
	
	
	/**
	 * 메시지를 가져온다.
	 * @param target 메시지 관리자
	 * @param key 메시지 코드
	 * @param defaultMessage 메시지 코드에 해당하는 메시지가 없을경우 사용할 메시지
	 * @return 코드에 해당하는 메시지, 만약 코드에 해당하는 메시지가 없는 경우 defaultMessage를 가져온다.
	 */
	public static String toMessage(String target, String key,  String defaultMessage){
		return toMessage(target, key, new String[]{}, defaultMessage);
	}
	
	/**
	 * 메시지를 가져온다.
	 * @param target 메시지 관리자
	 * @param key 메시지 코드
	 * @param param1 파라미터 1
	 * @param defaultMessage 메시지 코드에 해당하는 메시지가 없을경우 사용할 메시지
	 * @return 코드에 해당하는 메시지, 만약 코드에 해당하는 메시지가 없는 경우 defaultMessage를 가져온다.
	 */
	public static String toMessage(String target, String key, String param1, String defaultMessage){
		return toMessage(target, key, getParameters(param1, null, null,null), defaultMessage);
	}
	
	/**
	 * 메시지를 가져온다.
	 * @param target 메시지 관리자
	 * @param key 메시지 코드
	 * @param param1 파라미터 1
	 * @param param2 파라미터 2
	 * @param defaultMessage 메시지 코드에 해당하는 메시지가 없을경우 사용할 메시지
	 * @return 코드에 해당하는 메시지, 만약 코드에 해당하는 메시지가 없는 경우 defaultMessage를 가져온다.
	 */
	public static String toMessage(String target, String key, String param1, String param2, String defaultMessage){
		return toMessage(target, key, getParameters(param1, param2, null,null), defaultMessage);
	}
	
	/**
	 * 메시지를 가져온다.
	 * @param target 메시지 관리자
	 * @param key 메시지 코드
	 * @param param1 파라미터 1
	 * @param param2 파라미터 2
	 * @param param3 파라미터 3
	 * @param defaultMessage 메시지 코드에 해당하는 메시지가 없을경우 사용할 메시지
	 * @return 코드에 해당하는 메시지, 만약 코드에 해당하는 메시지가 없는 경우 defaultMessage를 가져온다.
	 */
	public static String toMessage(String target, String key, String param1, String param2, String param3, String defaultMessage){
		return toMessage(target, key, getParameters(param1, param2, param3,null), defaultMessage);
	}
	
	/**
	 * 메시지를 가져온다.
	 * @param target 메시지 관리자
	 * @param key 메시지 코드
	 * @param param1 파라미터 1
	 * @param param2 파라미터 2
	 * @param param3 파라미터 3
	 * @param param3 파라미터 4
	 * @param defaultMessage 메시지 코드에 해당하는 메시지가 없을경우 사용할 메시지
	 * @return 코드에 해당하는 메시지, 만약 코드에 해당하는 메시지가 없는 경우 defaultMessage를 가져온다.
	 */
	public static String toMessage(String target, String key, String param1, String param2, String param3, String param4, String defaultMessage){
		return toMessage(target, key, getParameters(param1, param2, param3,param4), defaultMessage);
	}
	
	/**
	 * 메시지 관리자를 통해 코드에 해당하는 메시지를 가져온다.
	 * @param target 메시지 관리자
	 * @param key 메시지 코드
	 * @param params 메시지 파라미터
	 * @param defaultMessage 메시지 코드에 해당하는 메시지가 없을경우 사용할 메시지
	 * @return 코드에 해당하는 메시지, 만약 코드에 해당하는 메시지가 없는 경우 defaultMessage를 가져온다.
	 */
	private static String toMessage(String target, String key, String[] params, String defaultMessage){
		String result = null;
		try {
			
			if(MESSAGE_COMMON.equals(target)){
				//일반 메시지 이면
				result = CommonMessage.INSTANCE.getMessage(key, params);
				
			}else if(MESSAGE_ERROR.equals(target)){
				//에러 메시지 이면
				result = ErrorMessage.INSTANCE.getMessage(key, params);
				
			}else if(MESSAGE_CODE.equals(target)){
				//코드 메시지 이면
				result = CodeMessage.INSTANCE.getMessage(key, params);
				
			}else if(MESSAGE_FIELD.equals(target)){
				//화면필드 메시지 이면
				result = FieldMessage.INSTANCE.getMessage(key, params);
			}
		}  catch (CanNotFindMessageException e) {
			//메시지 코드에 해당하는 , 메시지가 존재하지 않으면
			result = defaultMessage;
		} catch (MessagePropertiesLoadingException e) {
			//message properties가 로딩 되지 않은 경우
			result = defaultMessage;
		}
		return result;
	}
	
	/**
	 * 입력한 파라미터를 가지고 배열 형태로 변환한다.
	 * @param param1
	 * @param param2
	 * @param param3
	 * @param param4
	 * @return
	 */
	private  static String[] getParameters(String param1, String param2, String param3, String param4){
		//파라미터가 존재하면, 해당 파라미터를 셋팅한다.
		
		String[] params = null;
	
		List<String> temp_params = new ArrayList<String>();
		int cnt = 0;
		
		if(!ObjectUtils.isNone(param1)){
			temp_params.add(param1);
			cnt++;
		}
		
		if(!ObjectUtils.isNone(param2)){
			temp_params.add(param2);
			cnt++;
		}
		
		if(!ObjectUtils.isNone(param3)){
			temp_params.add(param3);
			cnt++;
		}
		
		if(!ObjectUtils.isNone(param4)){
			temp_params.add(param4);
			cnt++;
		}

		//파라미터 배열 객체 생성
		params = new String[cnt];
		
		//파라미터 배열에 해당 값을 입력한다.
		for(int i=0; i<cnt;i++){
			params[i] = temp_params.get(i);
		}
		return params;
	}
}
