package com.siriussoft.platform.core.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.siriussoft.platform.core.type.Item;
import com.siriussoft.platform.core.unit.AbstractModel;

/**
 * <pre>
 *	 List가 가지고 객체를 정렬 시킨다.
 * </pre>
 * 
 * @author 허병훈
 * @version 1.0 , 2014.10.25 최초 작성
 */
public class CompareUtils {

	public static final String SORT_ASC ="ASC"; 				//오름차순
	public static final String SORT_DESC ="DESC";			//내림차순
	
	
	/**
	 * List에 model 객체를 정렬한다.
	 * @param list model 객체 목록
	 * @param sort 정렬방법
	 * @return 정렬결과
	 */
	public static List<? extends AbstractModel> sortByListToModel(List<? extends AbstractModel> list, String sort) {
		
		if("ASC".equals(sort)){
			//오름차순이면
			Comparator<AbstractModel> comparator =  new Comparator<AbstractModel>() {
				public int compare(AbstractModel o1, AbstractModel o2) {
					return new Long(o1.getSortOrder()).compareTo(new Long(o2.getSortOrder()));
				}
			};
			Collections.sort(list, comparator);
		}else if("DESC".equals(sort)){
			//내림차순이면
			Comparator<AbstractModel> comparator =  new Comparator<AbstractModel>() {
				public int compare(AbstractModel o2, AbstractModel o1) {
					return new Long(o1.getSortOrder()).compareTo(new Long(o2.getSortOrder()));
				}
			};
			Collections.sort(list, comparator);
		}
		return list;
	}
	
	
	/**
	 * List에 문자열를 정렬한다.
	 * @param list 문자열 목록
	 * @param sort 정렬방법
	 * @return 정렬결과
	 */
	public static List<String> sortByListToString(List<String> list, String sort) {
	
		if("ASC".equals(sort)){
			Comparator<String> comparator =  new Comparator<String>() {
				public int compare(String o1, String o2) {
					if(o1 == null) o1="";
					if(o2== null) o2 ="";
					return o1.compareTo(o2);
				}
			};
			Collections.sort(list, comparator);
		}else if("DESC".equals(sort)){
			Comparator<String> comparator =  new Comparator<String>() {
				public int compare(String o2, String o1) {
					if(o1 == null) o1="";
					if(o2== null) o2 ="";
					return o1.compareTo(o2);
				}
			};
			Collections.sort(list, comparator);
		}
		return list;
	}
	
	/**
	 * List에 item(code)를 정렬한다.
	 * @param list item(code) 목록
	 * @param sort 정렬방법
	 * @return 정렬결과
	 */
	public static List<Item> sortByListToItem(List<Item> list, String sort) {
		
		if("ASC".equals(sort)){
			Comparator<Item> comparator =  new Comparator<Item>() {
				public int compare(Item o1, Item o2) {
					return new Integer(o1.getSortOrder()).compareTo(new Integer(o2.getSortOrder()));
				}
			};
			Collections.sort(list, comparator);
		}else if("DESC".equals(sort)){
			Comparator<Item> comparator =  new Comparator<Item>() {
				public int compare(Item o2, Item o1) {
					return new Integer(o1.getSortOrder()).compareTo(new Integer(o2.getSortOrder()));
				}
			};
			Collections.sort(list, comparator);
		}
		return list;
	}
}
