package com.siriussoft.platform.core.type;

import java.io.Serializable;


/**
 * <pre>
 *	 시스템에서 사용하는 코드를 정의한다.
 * </pre>
 * 
 * @author 허병훈
 * @version 1.0 , 2014.10.25 최초 작성
 */
public class Item implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private boolean check = false;				// 아이템이 선택 되었는지 여부
	private String key = null;						//아이템 코드
	private String label = null;						//아이템 이름				
	private String description = null;		//아이템 설명
	
	private int sortOrder = 0;						//우선순위
	
	/**
	 * 생성자
	 */
	public Item() {
		super();
	}

	/**
	 * 생성자
	 * @param check  아이템이 선택 되었는지 여부
	 * @param key 아이템 코드
	 * @param label 아이템 이름	
	 * @param sortOrder 우선순위
	 */
	public Item(boolean check, String key, String label, int sortOrder) {
		super();
		this.check = check;
		this.key = key;
		this.label = label;
		this.sortOrder = sortOrder;
	}

	/**
	 * 생성자
	 * @param check  아이템이 선택 되었는지 여부
	 * @param key 아이템 코드
	 * @param label 아이템 이름	
	 * @param description 아이템 설명
	 * @param sortOrder 우선순위
	 */
	public Item(boolean check, String key, String label, String description, int sortOrder) {
		super();
		this.check = check;
		this.key = key;
		this.label = label;
		this.description = description;
	}

	
	// Setter, Getter 메소드 영역
	
	
	/**
	 * 아이템이 선택 되었는지 여부를 가져온다.
	 * @return  아이템이 선택 되었는지 여부
	 */
	public boolean isCheck() {
		return check;
	}

	/**
	 * 아이템이 선택 되었는지 여부를 입력한다.
	 * @param check   아이템이 선택 되었는지 여부
	 */
	public void setCheck(boolean check) {
		this.check = check;
	}

	/**
	 * 아이템 코드를 가져온다.
	 * @return 아이템 코드
	 */
	public String getKey() {
		return key;
	}

	/**
	 *  아이템 코드를 입력한다.
	 * @param key 아이템 코드
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * 아이템 이름을 가져온다.
	 * @return 아이템 이름	
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * 아이템 이름을 입력한다.
	 * @param label 아이템 이름	
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * 아이템 설명 를 가져온다.
	 * @return 아이템 설명
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 아이템 설명를 입력한다.
	 * @param description 아이템 설명
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 우선순위를 가져온다.
	 * @return 우선순위
	 */
	public int getSortOrder() {
		return sortOrder;
	}

	/**
	 * 우선순위를 입력한다.
	 * @param sortOrder 우선순위
	 */
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
	
}
