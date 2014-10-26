/**
 * 
 */
package com.siriussoft.platform.core.exception;

import java.util.List;

/**
 * <pre>
 *		message properties에서 입력한 code에 해당하는 값을 찾을수 없는 경우에 대해 정의 한다.
 * </pre>
 * 
 * @author 허병훈
 * @version 1.0 , 2014.10.25 최초 작성
 */
public class CanNotFindMessageException extends AbstractException{

	private static final long serialVersionUID = 1L;

	/**
	 * 생성자
	 */
	public CanNotFindMessageException() {
		super();
	}
	
	/**
	 * 생성자
	 * @param e Throwable
	 */
	public CanNotFindMessageException(Throwable e) {
		super(e);
	}
	
	/**
	 * 생성자
	 * @param e Throwable
	 * @param message 메시지
	 */
	public CanNotFindMessageException( Throwable e,Message message) {
		super(e);
		this.addMessage(message);
	}
	
	/**
	 * 생성자
	 * @param e Throwable
	 * @param messages 메시지 목록
	 */
	public CanNotFindMessageException( Throwable e,List<Message> messages) {
		super( e);
		this.messages = messages;
	}

	/**
	 * 생성자
	 * @param message 메시지
	 */
	public CanNotFindMessageException(Message message) {
		super();
		this.addMessage(message);
	}
	
	/**
	 * 생성자
	 * @param messages 메시지 목록
	 */
	public CanNotFindMessageException(List<Message> messages) {
		super();
		this.messages = messages;
	}

}
