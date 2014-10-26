/**
 * 
 */
package com.siriussoft.platform.core;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.siriussoft.platform.core.conf.Config;
import com.siriussoft.platform.core.exception.CoreLoadException;
import com.siriussoft.platform.core.exception.Message;
import com.siriussoft.platform.core.exception.MessagePropertiesLoadingException;
import com.siriussoft.platform.core.instance.ClassIM;
import com.siriussoft.platform.core.instance.InstanceManager;
import com.siriussoft.platform.core.instance.RAsmIM;
import com.siriussoft.platform.core.message.CodeMessage;
import com.siriussoft.platform.core.message.CommonMessage;
import com.siriussoft.platform.core.message.ErrorMessage;
import com.siriussoft.platform.core.message.FieldMessage;
import com.siriussoft.platform.core.util.ObjectUtils;

/**
 * <pre>
 *	 Core 기능에 대해서 정의한다.
 * </pre>
 * 
 * @author 허병훈
 * @version 1.0 , 2014.10.26 최초 작성
 */
public enum Core {
	INSTANCE;

	private Config config = null;														//core-config.xml 정보
	private InstanceManager<?> instancemanager = null;    //instance manager

	/**
	 * Core를 초기화 한다.
	 * @param configFile core-config.xml 파일 경로
	 * @throws CoreLoadException core-config.xml 내용을 가져올수 없을 경우
	 * @throws MessagePropertiesLoadingException 만약 입력값이 null 이거나, resource 파일를 찾을수 없을 경우
	 */
	public void init(String configFile) throws  CoreLoadException, MessagePropertiesLoadingException{
		
		/****************************************************************************************************************************************************************************************************************
		 * 	설정 파일 분석 후 초기화 한다.
		 ****************************************************************************************************************************************************************************************************************/
		{
			System.out.println("######## CoreManager : load config( "+configFile+" )");
			
			try {
				JAXBContext context = JAXBContext.newInstance(Config.class);
				Unmarshaller unmarshaller = context.createUnmarshaller();
				this.config = (Config) unmarshaller.unmarshal(this.getClass().getClassLoader().getResourceAsStream(configFile));
			} catch (JAXBException e) {
				//TODO : throw exception
				throw new CoreLoadException(e, new Message("core-config.xml  파일을 찾을 수 없거나, xml 파일내 format이 잘못 되었습니다."));
			}
			
			if(this.config == null){
				//core-config.xml 내용을 가져오지 못한 경우
				
				//TODO : throw exception
				throw new CoreLoadException(new Message("core-config.xml 파일를 읽어 오지 못했습니다."));
			}
		}
		/****************************************************************************************************************************************************************************************************************
		 * 	message manager를 로딩한다.
		 ****************************************************************************************************************************************************************************************************************/
		{
			System.out.println("######## CoreManager : load MessageLoader");
			//일반 메시지
			CommonMessage.INSTANCE.init(this.config.getLanguage(), this.config.getMessageCommon());
			//오류 메시지
			ErrorMessage.INSTANCE.init(this.config.getLanguage(), this.config.getMessageException());
			//코드 메시지
			CodeMessage.INSTANCE.init(this.config.getLanguage(), this.config.getMessageCode());
			//화면 필드 메시지
			FieldMessage.INSTANCE.init(this.config.getLanguage(), this.config.getMessageField());
		}
		
		/****************************************************************************************************************************************************************************************************************
		 * 	instance manager를 로딩한다.
		 ****************************************************************************************************************************************************************************************************************/
		{
			System.out.println("######## CoreManager : load InstanceManager");

			if(this.config.getConfigInstance() == null){
				//core-config.xml에서 인스턴스 설정를 가져오지 못한 경우
				//TODO : throw exception
				throw new CoreLoadException(new Message("인스턴스 설정 정보를 읽어오지 못했습니다."));
			}
			
			if (this.config.getConfigInstance().toLowerCase().equals("rasm")) {
				this.instancemanager = new RAsmIM();
			}else{
				this.instancemanager = new ClassIM();
			}
		}
		
	}
	
	// Setter, Getter 메소드 영역
	
	
	/**
	 * core-config.xml 정보를 가져온다.
	 * @return core-config.xml 정보
	 */
	public Config getConfig() {
		return config;
	}

	/**
	 * core-config.xml 정보를 입력한다.
	 * @param config core-config.xml 정보
	 */
	public void setConfig(Config config) {
		this.config = config;
	}	
	
	/**
	 * instance manager를 가져온다.
	 * @return instance manager
	 */
	public InstanceManager<?> getInstancemanager() {
		return instancemanager;
	}

	/**
	 * instance manager를 입력한다.
	 * @param instancemanager instance manager
	 */
	public void setInstancemanager(InstanceManager<?> instancemanager) {
		this.instancemanager = instancemanager;
	}
}
