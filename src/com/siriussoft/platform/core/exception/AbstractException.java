package com.siriussoft.platform.core.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *		예외 처리에 대한 정의한다. 시스템에서 사용하는 모든 예외는 해당 클래스를 상속받아서 구현한다.
 * </pre>
 * 
 * @author 허병훈
 * @version 1.0 , 2014.10.25 최초 작성
 */
public class AbstractException extends Exception{

	private static final long serialVersionUID = 1L;

	protected List<Message> messages = new ArrayList<Message>();  //메시지 목록
	
	/**
	 * 생성자
	 */
	public AbstractException() {
		super();
	}
	
	/**
	 * 생성자
	 * @param e Throwable
	 */
	public AbstractException(Throwable e) {
		super(e);
	}
	
	/**
	 * 생성자
	 * @param e Throwable
	 * @param message 메시지
	 */
	public AbstractException( Throwable e,Message message) {
		super(e);
		this.addMessage(message);
	}
	
	/**
	 * 생성자
	 * @param e Throwable
	 * @param messages 메시지 목록
	 */
	public AbstractException( Throwable e,List<Message> messages) {
		super( e);
		this.messages = messages;
	}

	/**
	 * 생성자
	 * @param message 메시지
	 */
	public AbstractException(Message message) {
		super();
		this.addMessage(message);
	}
	
	/**
	 * 생성자
	 * @param messages 메시지 목록
	 */
	public AbstractException(List<Message> messages) {
		super();
		this.messages = messages;
	}
	
	/**
	 * 메시지를 추가한다.
	 * @param message 메시지
	 */
	public void addMessage(Message message){
		this.messages.add(message);
	}
	
	
	/**
	 * 메시지를 가져온다.
	 */
	@Override
	public String getMessage() {
		String result ="";
		result += "\n*****************************************************************************************************************************************************************************\n";
		
		for(Message message : this.messages){
			result += "\n\t\t  - : " + message.toString();
		}
		result +="\n\n*****************************************************************************************************************************************************************************";
		return result;
	}
}
