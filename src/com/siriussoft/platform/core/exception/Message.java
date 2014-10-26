package com.siriussoft.platform.core.exception;

import com.siriussoft.platform.core.util.MessageUtils;
import com.siriussoft.platform.core.util.ObjectUtils;

/**
 * <pre>
 *		예외 발생에 대한 메시지를 담고 있는 객체이다. property 파일과 연계 해서 해당 메시지를 출력할 수 있다.
 * </pre>
 * 
 * @author 허병훈
 * @version 1.0 , 2014.10.25 최초 작성
 */
public class Message {

	private String messageCode = null;						//Message property에서 사용할 코드 값
	private String messageParameter1 = null;			//Message property에 넘겨줄 첫번째 파라미터 값
	private String messageParameter2 = null;			//Message property에 넘겨줄 두번째 파라미터 값
	private String messageParameter3 = null;			//Message property에 넘겨줄 세번째 파라미터 값
	private String messageParameter4 = null;			//Message property에 넘겨줄 네번째 파라미터 값
			
	private String message = null;									//Message 내용
	
	
	/**
	 * Message 클래스 생성자
	 */
	public Message(){
		super();
	}
	
	/**
	 * Message 클래스 생성자
	 * @param message Message 내용
	 */
	public Message(String message) {
		super();
		this.message = message;
	}
	
	/**
	 * Message 클래스 생성자
	 * @param messageCode Message property에서 사용할 코드 값
	 * @param message Message 내용
	 */
	public Message(String messageCode, String message) {
		super();
		this.messageCode = messageCode;
		this.message = message;
	}
	
	/**
	 * Message 클래스 생성자
	 * @param messageCode Message property에서 사용할 코드 값
	 * @param messageParameter1 Message property에 넘겨줄 첫번째 파라미터 값
	 * @param message Message 내용
	 */
	public Message(String messageCode, String messageParameter1, String message) {
		super();
		this.messageCode = messageCode;
		this.messageParameter1 = messageParameter1;
		this.message = message;
	}
	
	/**
	 * Message 클래스 생성자
	 * @param messageCode Message property에서 사용할 코드 값
	 * @param messageParameter1 Message property에 넘겨줄 첫번째 파라미터 값
	 * @param messageParameter2 Message property에 넘겨줄 두번째 파라미터 값
	 * @param message Message 내용
	 */
	public Message(String messageCode, String messageParameter1, String messageParameter2, String message) {
		super();
		this.messageCode = messageCode;
		this.messageParameter1 = messageParameter1;
		this.messageParameter2 = messageParameter2;
		this.message = message;
	}
	
	/**
	 * Message 클래스 생성자
	 * @param messageCode Message property에서 사용할 코드 값
	 * @param messageParameter1 Message property에 넘겨줄 첫번째 파라미터 값
	 * @param messageParameter2 Message property에 넘겨줄 두번째 파라미터 값
	 * @param messageParameter3 Message property에 넘겨줄 세번째 파라미터 값
	 * @param message Message 내용
	 */
	public Message(String messageCode, String messageParameter1, String messageParameter2, String messageParameter3, String message) {
		super();
		this.messageCode = messageCode;
		this.messageParameter1 = messageParameter1;
		this.messageParameter2 = messageParameter2;
		this.messageParameter3 = messageParameter3;
		this.message = message;
	}
	
	/**
	 * Message 클래스 생성자
	 * @param messageCode Message property에서 사용할 코드 값
	 * @param messageParameter1 Message property에 넘겨줄 첫번째 파라미터 값
	 * @param messageParameter2 Message property에 넘겨줄 두번째 파라미터 값
	 * @param messageParameter3 Message property에 넘겨줄 세번째 파라미터 값
	 * @param messageParameter4 Message property에 넘겨줄 네번째 파라미터 값
	 * @param message Message 내용
	 */
	public Message(String messageCode, String messageParameter1, String messageParameter2, String messageParameter3, String messageParameter4, String message) {
		super();
		this.messageCode = messageCode;
		this.messageParameter1 = messageParameter1;
		this.messageParameter2 = messageParameter2;
		this.messageParameter3 = messageParameter3;
		this.messageParameter4 = messageParameter4;
		this.message = message;
	}

	/**
	 * Message property에서 사용할 코드 값을 가져온다.
	 * @return Message property에서 사용할 코드 값
	 */
	public String getMessageCode() {
		return messageCode;
	}
	
	/**
	 * Message property에서 사용할 코드 값을 입력한다.
	 * @param messageCode Message property에서 사용할 코드 값
	 */
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	/**
	 * Message property에 넘겨줄 첫번째 파라미터 값을 가져온다.
	 * @return Message property에 넘겨줄 첫번째 파라미터 값
	 */
	public String getMessageParameter1() {
		return messageParameter1;
	}

	/**
	 * Message property에 넘겨줄 첫번째 파라미터 값을 입력한다.
	 * @param messageParameter1 Message property에 넘겨줄 첫번째 파라미터 값
	 */
	public void setMessageParameter1(String messageParameter1) {
		this.messageParameter1 = messageParameter1;
	}

	/**
	 * Message property에 넘겨줄 두번째 파라미터 값을 가져온다.
	 * @return Message property에 넘겨줄 두번째 파라미터 값
	 */
	public String getMessageParameter2() {
		return messageParameter2;
	}

	/**
	 * Message property에 넘겨줄 두번째 파라미터 값을 입력한다.
	 * @param messageParameter2 Message property에 넘겨줄 두번째 파라미터 값
	 */
	public void setMessageParameter2(String messageParameter2) {
		this.messageParameter2 = messageParameter2;
	}

	/**
	 * Message property에 넘겨줄 세번째 파라미터 값을 가져온다.
	 * @return Message property에 넘겨줄 세번째 파라미터 값
	 */
	public String getMessageParameter3() {
		return messageParameter3;
	}

	/**
	 * Message property에 넘겨줄 세번째 파라미터 값을 입력한다.
	 * @param messageParameter3 Message property에 넘겨줄 세번째 파라미터 값
	 */
	public void setMessageParameter3(String messageParameter3) {
		this.messageParameter3 = messageParameter3;
	}

	/**
	 * Message property에 넘겨줄 네번째 파라미터 값을 가져온다.
	 * @return Message property에 넘겨줄 네번째 파라미터 값
	 */
	public String getMessageParameter4() {
		return messageParameter4;
	}

	/**
	 * Message property에 넘겨줄 네번째 파라미터 값을 입력한다.
	 * @param messageParameter4 Message property에 넘겨줄 네번째 파라미터 값
	 */
	public void setMessageParameter4(String messageParameter4) {
		this.messageParameter4 = messageParameter4;
	}

	/**
	 * Message 내용을 가져온다.
	 * @return Message 내용
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Message 내용을 입력한다.
	 * @param message Message 내용
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 오류 메시지를 출력한다.
	 */
	@Override
	public String toString() {
		String result = null;

		if(ObjectUtils.isNone(this.messageCode)){
			//메시지 코드가 존재하지 않으면
			result = this.message;
		}else{
			result = MessageUtils.toMessage(MessageUtils.MESSAGE_ERROR, 
					this.messageCode, this.messageParameter1, this.messageParameter2, this.messageParameter3, this.messageParameter4, message);
		}
		return result;
	}
}
