package com.siriussoft.platform.core.unit;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *	 객체를 정의 한다. 모든 객체는 해당 클래스를 상속받아서 구현한다.
 * </pre>
 * 
 * @author 허병훈
 * @version 1.0 , 2014.10.25 최초 작성
 */
abstract public class AbstractModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected boolean check = false; 				//선택했는지 여부
	protected long sortOrder = 0;                     //우선순위
	
	protected String modifierId = null;				//수정한 사람 아이디        
	protected String creatorId = null;              //생성한 사람 아이디
	protected Date modifiedDate = null;        //수정한 일자
	protected Date createdDate = null;           //생성한 일자
	
	protected Map<String, Boolean> updateField = new HashMap<String, Boolean>();  //수정대상 필드 정보를 담고 있는 Map 객체 , 필드명 : 수정여부

	/**
	 * 생성자
	 */
	public AbstractModel() {
		super();
	}
	
	/**
	 * 객체의 식별 클래스를 반환한다.
	 * @return
	 */
	abstract public AbstractKey getKey();
	
	/**
	 * 객체의 식별 클래스를 입력한다.
	 * @param key
	 */
	abstract public void setKey(AbstractKey key);

	
	/**
	 * 개체가 가지고 있는 필드 및 입력된 값을 문자열로 반환한다.
	 */
	@Override
	abstract public String toString();
	
	
	/**
	 * 객체를 복사한다.
	 * @param target 복사 대상이 되는 객체
	 */
	abstract public void copy(AbstractModel target);
	
	
	/**
	 *객체에 식별자가 존재하는지 확인한다.
	 * @return 식별자가 존재하면 true를 반환한다.
	 */
	public boolean isExist(){
		return this.getKey().isExist();
	}
	
	/**
	 * 식별자를 비교한다.
	 * @param target 비교 대상이 되는 객체
	 * @return 두 식별가가 같으면 true를 반환한다.
	 */
	public boolean equals(AbstractModel target){
		if(!this.isExist()){
			return false;
		}
		return this.getKey().equals(target.getKey());
	}
	
	
	/**
	 * 수정대상이 되는 필드를 추가한다.
	 * @param fieldName 수정대상이 되는 필드
	 * @return 수정대상 필드를 추가하면  true를 반환한다.
	 */
	protected boolean addFieldUpdate(String fieldName){
		return	this.updateField.put(fieldName, true);
	}
	
	
	/**
	 *수정대상이 되는 필드에서 해당건을 제거한다.
	 * @param fieldName 수정대상에서 제거되어야 하는 필드
	 * @return 수정대상이 되는 필드에서 해당건을 제거하면 true를 반환한다.
	 */
	protected boolean removeFieldUpdate(String fieldName){
		return this.updateField.remove(fieldName);
	}
	
	/**
	 * 수정대상이 되는 필드를 초기화 한다.
	 * @return 수정대상이 되는 필드가 초기화 되면 true를 반환한다.
	 */
	public boolean initUpdateField(){
		this.updateField = new HashMap<String, Boolean>();
		return true;
	}

	
	/**
	 * 수정대상에서 입력한 필드가 존재하는지 확인한다.
	 * @param fieldName 확인대상 필드
	 * @return 수정대상에 확인대상 필드가 존재하면 true를 반환한다.
	 */
	protected boolean isExistUpdate(String fieldName){
		boolean result = false;
		
		if(this.updateField.get(fieldName)){
			result = true;
		}
		
		return result;
	}
	
	/**
	 * 객체에서 이름을 반환한다.
	 * @return
	 */
	abstract public String getLabel();
	
	
	
	// Setter, Getter 메소드 영역
	
	
	/**
	 * 선택했는지 여부를 가져온다.
	 * @return 선택했는지 여부
	 */
	public boolean isCheck() {
		return check;
	}

	/**
	 * 선택했는지 여부를 입력한다.
	 * @param check 선택했는지 여부
	 */
	public void setCheck(boolean check) {
		this.check = check;
	}

	/**
	 * 우선순위을 가져온다.
	 * @return 우선순위
	 */
	public long getSortOrder() {
		return sortOrder;
	}

	/**
	 * 우선순위를 입력한다.
	 * @param sortOrder 우선순위
	 */
	public void setSortOrder(long sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
	 * 수정한 사람 아이디을 가져온다.
	 * @return 수정한 사람 아이디  
	 */
	public String getModifierId() {
		return modifierId;
	}

	/**
	 * 수정한 사람 아이디를 입력한다. 
	 * @param modifierId 수정한 사람 아이디  
	 */
	public void setModifierId(String modifierId) {
		this.modifierId = modifierId;
	}

	/**
	 * 생성한 사람 아이디을 가져온다.
	 * @return 생성한 사람 아이디
	 */
	public String getCreatorId() {
		return creatorId;
	}

	/**
	 * 생성한 사람 아이디를 입력한다.
	 * @param creatorId 생성한 사람 아이디
	 */
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	/**
	 * 수정한 일자을 가져온다.
	 * @return 수정한 일자
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 수정한 일자를 입력한다.
	 * @param modifiedDate 수정한 일자
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 생성한 일자을 가져온다.
	 * @return 생성한 일자
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * 생성한 일자를 입력한다.
	 * @param createdDate 생성한 일자
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * 수정대상 필드 정보를 담고 있는 Map 객체를 가져온다.
	 * @return 수정대상 필드 정보를 담고 있는 Map 객체
	 */
	public Map<String, Boolean> getUpdateField() {
		return updateField;
	}

	/**
	 * 수정대상 필드 정보를 담고 있는 Map 객체를 입력한다.
	 * @param updateField 수정대상 필드 정보를 담고 있는 Map 객체
	 */
	public void setUpdateField(Map<String, Boolean> updateField) {
		this.updateField = updateField;
	}
	
	
	
}