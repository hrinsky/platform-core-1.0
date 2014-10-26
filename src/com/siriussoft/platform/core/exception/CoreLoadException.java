/**
 * 
 */
package com.siriussoft.platform.core.exception;

import java.util.List;

/**
 * <pre>
 *		Core load시 발생한 오류에 대해서 정의한다.
 * </pre>
 * 
 * @author 허병훈
 * @version 1.0 , 2014.10.25 최초 작성
 */
public class CoreLoadException extends AbstractException{

	private static final long serialVersionUID = 1L;

	/**
	 * 생성자
	 */
	public CoreLoadException() {
		super();
	}
	
	/**
	 * 생성자
	 * @param e Throwable
	 */
	public CoreLoadException(Throwable e) {
		super(e);
	}
	
	/**
	 * 생성자
	 * @param e Throwable
	 * @param message 메시지
	 */
	public CoreLoadException( Throwable e,Message message) {
		super(e);
		this.addMessage(message);
	}
	
	/**
	 * 생성자
	 * @param e Throwable
	 * @param messages 메시지 목록
	 */
	public CoreLoadException( Throwable e,List<Message> messages) {
		super( e);
		this.messages = messages;
	}

	/**
	 * 생성자
	 * @param message 메시지
	 */
	public CoreLoadException(Message message) {
		super();
		this.addMessage(message);
	}
	
	/**
	 * 생성자
	 * @param messages 메시지 목록
	 */
	public CoreLoadException(List<Message> messages) {
		super();
		this.messages = messages;
	}

}
