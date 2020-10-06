




// ______________________________________________________
// Generated by sql2java - http://sql2java.sourceforge.net/
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
//
// Author: Javed Kansi
// ______________________________________________________

package uk.co.planetbeyond.managedbean;

import uk.co.planetbeyond.generated.ContentBean;
import com.sleepycat.persist.model.Persistent;

/**
* If any changes needs to be made to the ContentBean, it MUST not be made directly to ContentBean
* Instead the ContentManagedBean should be used to make the changes
*/
@Persistent
public class ContentManagedBean extends ContentBean
{
	private static final long serialVersionUID = -5334125972627591344L;

	/**
	* Make the constructor public so that it can be accessed externally
	*/
	public ContentManagedBean()
	{
		super();
	}
}
