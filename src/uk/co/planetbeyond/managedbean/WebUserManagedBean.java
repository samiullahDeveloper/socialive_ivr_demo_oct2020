




// ______________________________________________________
// Generated by sql2java - http://sql2java.sourceforge.net/
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
//
// Author: Javed Kansi
// ______________________________________________________

package uk.co.planetbeyond.managedbean;

import uk.co.planetbeyond.generated.WebUserBean;
import com.sleepycat.persist.model.Persistent;

/**
* If any changes needs to be made to the WebUserBean, it MUST not be made directly to WebUserBean
* Instead the WebUserManagedBean should be used to make the changes
*/
@Persistent
public class WebUserManagedBean extends WebUserBean
{
	private static final long serialVersionUID = -3557033086366765809L;

	/**
	* Make the constructor public so that it can be accessed externally
	*/
	public WebUserManagedBean()
	{
		super();
	}
}
