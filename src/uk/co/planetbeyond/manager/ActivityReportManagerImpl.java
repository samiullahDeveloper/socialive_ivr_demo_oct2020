// ______________________________________________________
// Generated by sql2java - http://sql2java.sourceforge.net/
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
//
// Author: Javed Kansi
// ______________________________________________________

package uk.co.planetbeyond.manager;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.planetbeyond.generated.ActivityReportBean;
import uk.co.planetbeyond.generated.ActivityReportManager;
import uk.co.planetbeyond.generated.exception.DAOException;
import uk.co.planetbeyond.managedbean.ActivityReportManagedBean;

/**
 * If any change needs to be made to the ActivityReportManager, it MUST not be made directly Instead the ActivityReportManagerImpl class should be
 * used to make the changes
 */
public class ActivityReportManagerImpl extends ActivityReportManager
{
	private static Logger log = LoggerFactory.getLogger(ActivityReportManagerImpl.class);

	/**
	 * Singleton instance of this class
	 */
	private static ActivityReportManagerImpl singleton = new ActivityReportManagerImpl();

	/**
	 * Make the constructor private to make the class singleton
	 */
	private ActivityReportManagerImpl()
	{
		super();

		// set the singleton instance of ActivityReportManagerImpl class in the ActivityReportManager so that
		// ActivityReportManager.getInstance() also points to the singleton instance of ActivityReportManagerImpl
		setInstance(this);
	}

	/**
	 * To make the singleton instance available to external classes
	 */
	public static ActivityReportManagerImpl getInstance()
	{
		return singleton;
	}

	/**
	 * Override this method so that it returns an instance of ActivityReportManagedBean instead of ActivityReportBean
	 */
	@Override
	public ActivityReportBean createActivityReportBean()
	{
		return new ActivityReportManagedBean();
	}

	/**
	 * Creates a activity report bean for previous day with all stats set to 0
	 * 
	 * @return
	 * @throws DAOException
	 */
	public ActivityReportBean getReportBean(Date reportDate) throws DAOException
	{
		// Get activity report from database for the required date
		ActivityReportBean activityReportBean = getInstance().loadSingleEntryByPreparedStatement(" WHERE report_date = ?", new Object[] { new java.sql.Date(reportDate.getTime()) }, null);

		// If activityReportBean is null, create new activityReportBean. Set reportDate to required day's date
		if (activityReportBean == null)
		{
			log.error("No entry found in activity report for previous day. Unable to calculate all stats.");

			activityReportBean = getInstance().createActivityReportBean();
			activityReportBean.setReportDate(reportDate);

			// Save to database
			activityReportBean.save();

			// Reload the report bean from database to populate the default values
			// activityReportBean = getInstance().loadByPrimaryKey(activityReportBean.getReportDate());
		}

		return activityReportBean;
	}
}