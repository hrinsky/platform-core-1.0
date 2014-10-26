/**
 * 
 */
package com.siriussoft.platform.core.message;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import com.siriussoft.platform.core.exception.CanNotFindMessageException;
import com.siriussoft.platform.core.exception.Message;
import com.siriussoft.platform.core.exception.MessagePropertiesLoadingException;

/**
 * @author Administrator
 *
 */
public enum FieldMessage  {
	INSTANCE;
	
	private ResourceBundle resourcebundle; 	//message properties 정보
	private Locale locale;											//사용 언어
	private String resource;										//메지시 프로퍼티 파일

	/**
	 * Common message properties에서 데이터를 로딩한다.
	 * @param language 사용언어
	 * @param resource  message properties
	 * @throws MessagePropertiesLoadingException 만약 입력값이 null 이거나, resource 파일를 찾을수 없을 경우
	 */
	public void init(String language, String resource) throws MessagePropertiesLoadingException {
		try {
			this.resource = resource;
			
			locale = new Locale(language);
			resourcebundle = ResourceBundle.getBundle(resource, locale);
		} catch (Exception e) {
			//TODO : throw exception
			throw new MessagePropertiesLoadingException(e, new Message("message properties -> "+resource+"  로딩중 오류가 발생했습니다."));
		}
	}
	

	/**
	 * 입력한 키에 해당하는 메시지를 가져온다.
	 * @param key 메시지 코드
	 * @return 메시지 코드에 해당하는 메시지
	 * @throws CanNotFindMessageException 만약 메시지 코드에 해당하는 메시지가 message properties에 존재 하지 않는 경우
	 * @throws MessagePropertiesLoadingException message properties가 로딩 되지 않은 경우
	 */
	public String getMessage(String key) throws CanNotFindMessageException, MessagePropertiesLoadingException{
		return this.getMessage(key, new String[]{});
	}
	
	
	/**
	 * 입력한 키 및 파라미터에 해당하는 메시지를 가져온다.
	 * @param key 메시지 코드
	 * @param params  파라미터
	 * @return 메시지 코드에 해당하는 메시지
	 * @throws CanNotFindMessageException 만약 메시지 코드에 해당하는 메시지가 message properties에 존재 하지 않는 경우
	 * @throws MessagePropertiesLoadingException message properties가 로딩 되지 않은 경우
	 */
	public String getMessage(String key, String... params) throws CanNotFindMessageException, MessagePropertiesLoadingException {
		String result = null;
		
		if(this.resourcebundle == null){
			//TODO : throw exception
			throw new MessagePropertiesLoadingException(new Message("field message properties 가 로딩 되지 않았습니다."));
		}
		
		try {
			MessageFormat messageFormat = new MessageFormat(resourcebundle.getString(key),  locale);
			result = messageFormat.format(params);
		} catch (Exception e) {
			//TODO : throw exception
			throw new CanNotFindMessageException(e, new Message("message properties -> "+resource+" 에 코드("+key+")에 해당하는 메시지가 존재 하지 않습니다."));
		}
		return result;
	}
}
