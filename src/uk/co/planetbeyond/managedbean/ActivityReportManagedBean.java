




// ______________________________________________________
// Generated by sql2java - http://sql2java.sourceforge.net/
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
//
// Author: Javed Kansi
// ______________________________________________________

package uk.co.planetbeyond.managedbean;

import uk.co.planetbeyond.generated.ActivityReportBean;
import com.sleepycat.persist.model.Persistent;

/**
* If any changes needs to be made to the ActivityReportBean, it MUST not be made directly to ActivityReportBean
* Instead the ActivityReportManagedBean should be used to make the changes
*/
@Persistent
public class ActivityReportManagedBean extends ActivityReportBean
{
	private static final long serialVersionUID = 737073682487933372L;

	/**
	* Make the constructor public so that it can be accessed externally
	*/
	public ActivityReportManagedBean()
	{
		super();
	}
}
