




// ______________________________________________________
// Generated by sql2java - http://sql2java.sourceforge.net/
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
//
// Author: Javed Kansi
// ______________________________________________________

package uk.co.planetbeyond.managedbean;

import uk.co.planetbeyond.generated.SegmentReportBean;
import com.sleepycat.persist.model.Persistent;

/**
* If any changes needs to be made to the SegmentReportBean, it MUST not be made directly to SegmentReportBean
* Instead the SegmentReportManagedBean should be used to make the changes
*/
@Persistent
public class SegmentReportManagedBean extends SegmentReportBean
{
	private static final long serialVersionUID = -2002505637287205556L;

	/**
	* Make the constructor public so that it can be accessed externally
	*/
	public SegmentReportManagedBean()
	{
		super();
	}
}
