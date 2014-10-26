/**
 * 
 */
package test;

import com.siriussoft.platform.core.Core;
import com.siriussoft.platform.core.exception.CoreLoadException;
import com.siriussoft.platform.core.exception.MessagePropertiesLoadingException;

/**
 * @author Administrator
 *
 */
public class CoreTest {

	public static void main(String args[]){
		
		try {
			Core.INSTANCE.init("core-config.xml");
			
		} catch (MessagePropertiesLoadingException e) {
			e.printStackTrace();
		} catch (CoreLoadException e) {
			e.printStackTrace();
		} 
	}
}
