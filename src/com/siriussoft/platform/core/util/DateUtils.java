/**
 * 
 */
package com.siriussoft.platform.core.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <pre>
 *	 Date 객체에 대한 기능을 정의한다.
 * </pre>
 * 
 * @author 허병훈
 * @version 1.0 , 2014.10.26 최초 작성
 */
public class DateUtils {

	public final static int YEAR = 1;				//년
	public final static int MONTH =2;			//월
	public final static int DATE =3;				//일
	public final static int HOUR =4;			//시
	public final static int MINUTE=5;			//분	
	public final static int SECOND =6;		//초

	/**
	 * 현재 일자를 가져온다.
	 * @return 현재일자
	 */
	public static Date getCurrentDateTime(){
		return Calendar.getInstance().getTime();
	}
	
	/**
	 * 현재일자를 입력한 format으로 가져온다.
	 * @param format  예)mm.dd.yyyyy
	 * @return 입력한 format이 적용된 일자
	 */
	public static String getCurrentDateTime(String format){
		String result = null;
		try{
			result = new SimpleDateFormat(format).format(DateUtils.getCurrentDateTime());
		}catch(NullPointerException e){
			
		}catch(IllegalArgumentException e){
			
		}
		return result;
	}
	
}
