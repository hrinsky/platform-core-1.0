package com.siriussoft.platform.core.unit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.siriussoft.platform.core.util.CompareUtils;
import com.siriussoft.platform.core.util.ObjectUtils;


/**
 * <pre>
 *	 검색 조건에 해당하는 객체 목록을  정의 한다. 모든 객체 목론은 해당 클래스를 상속받아서 구현한다.
 * </pre>
 * 
 * @author 허병훈
 * @version 1.0 , 2014.10.25 최초 작성
 */
abstract public class AbstractModels implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String PAGING_SORT_TYPE_ASC ="ASC";						//Paging sort asc
	public static final String PAGING_SORT_TYPE_DESC ="DESC";					//Paging sort desc
	
	protected int rows = 10;																						//한페이지당 보여줄 목록 갯수
	protected int page = 1;																							//페이지 
	protected int totalRows = 0;																					//전체 목록 갯수
	
	protected String pagingSort = null;																	//Paging sort 대상 필드
	protected String pagingSortType = null;															//Paging sort 방법 

	protected List<AbstractModel> list = null;														//검색 조건에 해당하는 객체목록
	
	protected Map<String, Boolean> searchField = new HashMap<String, Boolean>();		 //검색 조건 대상 필드 정보를 담고 있는 Map 객체 

	/**
	 * 생성자
	 */
	public AbstractModels() {
		super();
	}
	
	/**
	 * 생성자
	 * @param rows 한페이지당 보여줄 목록 갯수
	 * @param page 페이지
	 * @param totalRows 전체 목록 갯수
	 * @param pagingSort Paging sort 대상 필드
	 * @param pagingSortType Paging sort 방법 
	 */
	public AbstractModels(int rows, int page, int totalRows, String pagingSort, String pagingSortType) {
		super();
		this.rows = rows;
		this.page = page;
		this.totalRows = totalRows;
		this.pagingSort = pagingSort;
		this.pagingSortType = pagingSortType;
	}
	
	
	/**
	 * 객체목록이 존재하는지 체크한다.
	 * @return 목록이 존재하면 true를 반환한다.
	 */
	public boolean isExist() {
		return this.list != null && this.list.size() > 0;
	}
	
	/**
	 * 객체 목록 갯수를 반환한다.
	 * @return 목로갯수
	 */
	public int size() {
		return this.isExist() ? list.size() : 0;
	}
	
	/**
	 * 객체목록에서 한개의 객체를 가져온다.
	 * @param index list index 값
	 * @return list에서 입력한 index에 해당하는 객체, list size 범위를 넘는 인덱스 입력 시 null를 반환한다.
	 */
	public AbstractModel get(int index)  {
		
		AbstractModel result = null;
		try {
			result = this.list.get(index);
		} catch (IndexOutOfBoundsException e) {
			  result = null;
		}
		return result;
	}
	
	/**
	 * 객체목록에서 대상 객체가 존재하는지 확인한다.
	 * @param target 대상이 되는 객체
	 * @return 객체가 존재하면 true를 반환한다.
	 */
	public boolean isExistModel(AbstractModel target) {
		boolean result = false;

		for (int i = 0; this.isExist() && i < this.size(); i++) {
		
			if (this.get(i).equals(target)) {
				//대상 객체와 같으면
				result = true;
				break;
			}
		}
		return result;
	}
	
	/**
	 * 객체목록에서 대상 객체가 존재하는 index를 가져온다.
	 * @param target 대상이 되는 객체
	 * @return 객체가 존재하면 해당 index, 존재하지 않으면 0를 반환한다.
	 */
	public int getIndexByList(AbstractModel target){
		int result = 0;

		for (int i = 0; this.isExist() && i < this.size(); i++) {
			if (this.get(i).equals(target)) {
				//대상 객체와 같으면
				result = i;
				break;
			}
		}
		return result;
	}
	
	
	/**
	 * 검색 대상이 되는 필드를 추가한다.
	 * @param fieldName 검색 대상이 되는 필드
	 * @return 검색 대상 필드를 추가하면  true를 반환한다.
	 */
	protected boolean addFieldSerach(String fieldName){
		return	this.searchField.put(fieldName, true);
	}
	
	
	/**
	 *검색 대상이 되는 필드에서 해당건을 제거한다.
	 * @param fieldName 검색대상에서 제거되어야 하는 필드
	 * @return 검색대상이 되는 필드에서 해당건을 제거하면 true를 반환한다.
	 */
	protected boolean removeFieldSearch(String fieldName){
		return this.searchField.remove(fieldName);
	}
	
	/**
	 * 검색대상이 되는 필드를 초기화 한다.
	 * @return 검색대상이 되는 필드가 초기화 되면 true를 반환한다.
	 */
	public boolean initSearchField(){
		this.searchField = new HashMap<String, Boolean>();
		return true;
	}

	
	/**
	 * 검색대상에서 입력한 필드가 존재하는지 확인한다.
	 * @param fieldName 확인대상 필드
	 * @return 검색대상에 확인대상 필드가 존재하면 true를 반환한다.
	 */
	protected boolean isExistSearch(String fieldName){
		boolean result = false;
		
		if(this.searchField.get(fieldName)){
			//확인대상 필드가 존재하면
			result = true;
		}
		
		return result;
	}
	
	/**
	 * Paging sort 내용을 가져온다.
	 * @return  Paging sort 내용
	 */
	public String getSort(){
		String result = "";

		if(!ObjectUtils.isNone(this.pagingSort) && !ObjectUtils.isNone(this.pagingSortType)){
			//paging sort 대상 필드  및 sort 방법이 존재하면
			result = this.pagingSort+ " "+this.pagingSortType;
		}else if(!ObjectUtils.isNone(this.pagingSort) && ObjectUtils.isNone(this.pagingSortType)){
			//paging sort 대상 필드 가 존재하고, sort 방법이 존재하지 않으면
			result = this.pagingSort+ " DESC";
		}else if(ObjectUtils.isNone(this.pagingSort) && !ObjectUtils.isNone(this.pagingSortType)){
			//paging sort 대상 필드가 존재하지 않고,  sort 방법이 존재하면
			result ="sortOrder"+ " "+this.pagingSortType;
		}else{
			//paging sort 대상 필드 및 sort 방법이 존재하지 않으면
			result ="sortOrder DESC";
		}
		return result;
	}
	
	/**
	 * 검색조건 필드 중에 다른 객체를 참조하고 있는 필드에 검색조건을 입력한다.
	 * @param key 참조하고 있는 객체의 식별자
	 */
	abstract protected void setForeignKey(AbstractKey key);
	
	
	/**
	 * 객체목록에 객체를 추가한다.
	 * @param model 목록에 추가할 객체
	 * @return 목록에 객체를 추가하면 true를 반환한다.
	 */
	public boolean add(AbstractModel model){
		
		if(ObjectUtils.isNone(list)){
			list = new ArrayList<AbstractModel>();
		}
		return list.add(model);
	}
	
	/**
	 * 객체목록에 해당 건이 존재하는지 확인 후, 존재하면 해당 객체로 변경한다.
	 * @param model 변경대상 객체
	 * @return 목록에 객체를 변경하면 true, 객체가 존재하지 않거나, 변경 실패하면 false를 반환한다. 
	 */
	public boolean  edit(AbstractModel model) {
		boolean result = false;
		
		List<AbstractModel> temp = new ArrayList<AbstractModel>();
		
		for(int i=0; this.isExist() && i < this.size() ; i++){
			if (this.get(i).equals(model)) {
				result = temp.add(model);
			}else{
				temp.add(this.get(i));
			}
		}
		this.list = temp;
		return result;
	}
	
	/**
	 * 객체목록에서 해당건을 제거한다.
	 * @param key 제거대상 식별자
	 * @return 목록에 객체를 제거하면 true, 객체가 존재하지 않거나, 제거 실패하면 false를 반환한다.
	 */
	public boolean remove(AbstractKey key){
		boolean result = false; 
		List<AbstractModel> temp = new ArrayList<AbstractModel>();
		
		for(int i=0; this.isExist() && i < this.size() ; i++){
			if (!this.get(i).getKey().equals(key)) {
				temp.add(this.get(i));
			}else{
				result = true;
			}
		}
		this.list = temp;
		return result;
	}
	
	
	/**
	 * 객체목록을 정렬한다.
	 * @param sort
	 */
	public void sorting(String sort){
		this.list = (List<AbstractModel>) CompareUtils.sortByListToModel(this.list, sort);
	}
	
	
	// Setter, Getter 메소드 영역
	
	
	/**
	 *  한페이지당 보여줄 목록 갯수를 가져온다.
	 * @return 한페이지당 보여줄 목록 갯수
	 */
	public int getRows() {
		return rows;
	}

	/**
	 *  한페이지당 보여줄 목록 갯수를 입력한다.
	 * @param rows 한페이지당 보여줄 목록 갯수
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 *  페이지를 가져온다.
	 * @return 페이지 
	 */
	public int getPage() {
		return page;
	}

	/**
	 *  페이지를 입력한다.
	 * @param page 페이지 
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * 전체 목록 갯수를 가져온다.
	 * @return 전체 목록 갯수
	 */
	public int getTotalRows() {
		return totalRows;
	}

	/**
	 * 전체 목록 갯수를 입력한다.
	 * @param totalRows 전체 목록 갯수
	 */
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	/**
	 * Paging sort 대상 필드를 가져온다.
	 * @return Paging sort 대상 필드
	 */
	public String getPagingSort() {
		return pagingSort;
	}

	/**
	 * Paging sort 대상 필드를 입력한다.
	 * @param pagingSort Paging sort 대상 필드
	 */
	public void setPagingSort(String pagingSort) {
		this.pagingSort = pagingSort;
	}

	/**
	 * Paging sort 방법를 가져온다.
	 * @return Paging sort 방법 
	 */
	public String getPagingSortType() {
		return pagingSortType;
	}

	/**
	 * Paging sort 방법를 입력한다.
	 * @param pagingSortType Paging sort 방법 
	 */
	public void setPagingSortType(String pagingSortType) {
		this.pagingSortType = pagingSortType;
	}

	/**
	 *  검색 조건에 해당하는 객체목록를 가져온다.
	 * @return 검색 조건에 해당하는 객체목록
	 */
	public List<? extends AbstractModel> getList() {
		return list;
	}

	/**
	 *  검색 조건에 해당하는 객체목록를 입력한다.
	 * @param list 검색 조건에 해당하는 객체목록
	 */
	public void setList(List<? extends AbstractModel> list) {
		this.list = (List<AbstractModel>) list;
	}

	/**
	 * 검색 조건 대상 필드 정보를 담고 있는 Map 객체를 가져온다.
	 * @return 검색 조건 대상 필드 정보를 담고 있는 Map 객체
	 */
	public Map<String, Boolean> getSearchField() {
		return searchField;
	}

	/**
	 * 검색 조건 대상 필드 정보를 담고 있는 Map 객체를 입력한다.
	 * @param searchField 검색 조건 대상 필드 정보를 담고 있는 Map 객체 
	 */
	public void setSearchField(Map<String, Boolean> searchField) {
		this.searchField = searchField;
	}
	
}
