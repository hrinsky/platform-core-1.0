/**
 * 
 */
package com.siriussoft.platform.core.exception;

import java.util.List;

/**
 * <pre>
 *		message properties loading 중 발생한 오류에대해서 정의한다.
 * </pre>
 * 
 * @author 허병훈
 * @version 1.0 , 2014.10.25 최초 작성
 */
public class MessagePropertiesLoadingException extends AbstractException{

	private static final long serialVersionUID = 1L;

	/**
	 * 생성자
	 */
	public MessagePropertiesLoadingException() {
		super();
	}
	
	/**
	 * 생성자
	 * @param e Throwable
	 */
	public MessagePropertiesLoadingException(Throwable e) {
		super(e);
	}
	
	/**
	 * 생성자
	 * @param e Throwable
	 * @param message 메시지
	 */
	public MessagePropertiesLoadingException( Throwable e,Message message) {
		super(e);
		this.addMessage(message);
	}
	
	/**
	 * 생성자
	 * @param e Throwable
	 * @param messages 메시지 목록
	 */
	public MessagePropertiesLoadingException( Throwable e,List<Message> messages) {
		super( e);
		this.messages = messages;
	}

	/**
	 * 생성자
	 * @param message 메시지
	 */
	public MessagePropertiesLoadingException(Message message) {
		super();
		this.addMessage(message);
	}
	
	/**
	 * 생성자
	 * @param messages 메시지 목록
	 */
	public MessagePropertiesLoadingException(List<Message> messages) {
		super();
		this.messages = messages;
	}

}
