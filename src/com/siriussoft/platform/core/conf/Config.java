/**
 * 
 */
package com.siriussoft.platform.core.conf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 *	 core-config.xml 정보를 정의한다.
 * </pre>
 * 
 * @author 허병훈
 * @version 1.0 , 2014.10.26 최초 작성
 */
@XmlRootElement(name="config")
@XmlAccessorType(XmlAccessType.FIELD)
public class Config {
	
	protected String language  = null ;								//시스템에서 사용하는 언어
	protected String format  = null ;										//시스템에서 사용할 일자에 대한 포멧
	
	protected String messageException = null;				//예외처리 메시지 파일 경로
	protected String messageCode = null;						//코드 메시지 파일 경로	
	protected String messageCommon = null;				//일반 메시지 파일 경로
	protected String messageField = null;						//화면필드 메시지 파일 경로
	
	protected String configInstance  = null ;					//Instance 생성 manager 설정 정보
	
	
	
	// Setter, Getter 메소드 영역
	

	/**
	 * 시스템에서 사용하는 언어를 가져온다.
	 * @return 시스템에서 사용하는 언어
	 */
	public String getLanguage() {
		return language;
	}
	
	/**
	 * 시스템에서 사용하는 언어를 가져온다.
	 * @param language 시스템에서 사용하는 언어
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	/**
	 * 시스템에서 사용하는 언어를 입력한다.
	 * @return 시스템에서 사용하는 언어
	 */
	public String getFormat() {
		return format;
	}
	
	/**
	 * 시스템에서 사용할 일자에 대한 포멧를 가져온다.
	 * @param format 시스템에서 사용할 일자에 대한 포멧
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * 예외처리 메시지 파일 경로를 가져온다.
	 * @return 예외처리 메시지 파일 경로
	 */
	public String getMessageException() {
		return messageException;
	}

	/**
	 * 예외처리 메시지 파일 경로를 입력한다.
	 * @param messageException 예외처리 메시지 파일 경로
	 */
	public void setMessageException(String messageException) {
		this.messageException = messageException;
	}

	/**
	 * 코드 메시지 파일 경로를 가져온다.	
	 * @return 코드 메시지 파일 경로	
	 */
	public String getMessageCode() {
		return messageCode;
	}

	/**
	 * 코드 메시지 파일 경로를 입력한다.
	 * @param messageCode 코드 메시지 파일 경로	
	 */
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	/**
	 * 일반 메시지 파일 경로를 가져온다.
	 * @return 일반 메시지 파일 경로
	 */
	public String getMessageCommon() {
		return messageCommon;
	}

	/**
	 * 일반 메시지 파일 경로를 입력한다.
	 * @param messageCommon 일반 메시지 파일 경로
	 */
	public void setMessageCommon(String messageCommon) {
		this.messageCommon = messageCommon;
	}

	/**
	 * 화면필드 메시지 파일 경로를 가져온다.
	 * @return 화면필드 메시지 파일 경로
	 */
	public String getMessageField() {
		return messageField;
	}

	/**
	 * 화면필드 메시지 파일 경로를 입력한다.
	 * @param messageField 화면필드 메시지 파일 경로
	 */
	public void setMessageField(String messageField) {
		this.messageField = messageField;
	}
	
	/**
	 * Instance 생성 manager 설정 정보를 가져온다.
	 * @return Instance 생성 manager 설정 정보
	 */
	public String getConfigInstance() {
		return configInstance;
	}

	/**
	 * Instance 생성 manager 설정 정보를 입력한다.
	 * @param configInstance Instance 생성 manager 설정 정보
	 */
	public void setConfigInstance(String configInstance) {
		this.configInstance = configInstance;
	}
	
	
}
