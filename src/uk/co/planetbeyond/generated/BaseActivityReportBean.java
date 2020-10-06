




// ______________________________________________________
// Generated by sql2java - http://sql2java.sourceforge.net/
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
//
// Author: Javed Kansi
// ______________________________________________________

package uk.co.planetbeyond.generated;

import java.io.Serializable;
import com.sleepycat.persist.model.Persistent;
import org.apache.commons.lang.builder.EqualsBuilder;

import uk.co.planetbeyond.manager.ActivityReportManagerImpl;

/**
 * ActivityReportBean is a mapping of activity_report Table.
 * @author sql2java
*/
@Persistent
public class BaseActivityReportBean extends BaseGeneratedBean implements Serializable
{
	private static final long serialVersionUID = -22141528167004907L;
	
    protected Integer nonSubscribersTotalUniqueIvrCalls;
    protected Integer nonSubscribersTotalIvrCalls;
    protected Integer nonSubscribersTotalIvrMinutes;
    protected Integer subscribersTotalUniqueIvrCalls;
    protected Integer subscribersTotalIvrCalls;
    protected Integer subscribersTotalIvrMinutes;
    protected java.util.Date reportDate;
    protected Integer activityReportId;

    /**
     * Prefered methods to create a ActivityReportBean is via the createActivityReportBean method in ActivityReportManager or
     * via the factory class ActivityReportFactory create method
     */
    public BaseActivityReportBean()
    {
    }

    /**
     * Getter method for nonSubscribersTotalUniqueIvrCalls.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: activity_report.non_subscribers_total_unique_ivr_calls</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of nonSubscribersTotalUniqueIvrCalls
     */
    public Integer getNonSubscribersTotalUniqueIvrCalls()
    {
        return nonSubscribersTotalUniqueIvrCalls;
    }

    /**
     * Setter method for nonSubscribersTotalUniqueIvrCalls.
     * <br>
     *
     * @param newVal the new value to be assigned to nonSubscribersTotalUniqueIvrCalls
     */
    public void setNonSubscribersTotalUniqueIvrCalls(Integer newVal)
    {
        nonSubscribersTotalUniqueIvrCalls = newVal;
    }

    /**
     * Getter method for nonSubscribersTotalIvrCalls.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: activity_report.non_subscribers_total_ivr_calls</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of nonSubscribersTotalIvrCalls
     */
    public Integer getNonSubscribersTotalIvrCalls()
    {
        return nonSubscribersTotalIvrCalls;
    }

    /**
     * Setter method for nonSubscribersTotalIvrCalls.
     * <br>
     *
     * @param newVal the new value to be assigned to nonSubscribersTotalIvrCalls
     */
    public void setNonSubscribersTotalIvrCalls(Integer newVal)
    {
        nonSubscribersTotalIvrCalls = newVal;
    }

    /**
     * Getter method for nonSubscribersTotalIvrMinutes.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: activity_report.non_subscribers_total_ivr_minutes</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of nonSubscribersTotalIvrMinutes
     */
    public Integer getNonSubscribersTotalIvrMinutes()
    {
        return nonSubscribersTotalIvrMinutes;
    }

    /**
     * Setter method for nonSubscribersTotalIvrMinutes.
     * <br>
     *
     * @param newVal the new value to be assigned to nonSubscribersTotalIvrMinutes
     */
    public void setNonSubscribersTotalIvrMinutes(Integer newVal)
    {
        nonSubscribersTotalIvrMinutes = newVal;
    }

    /**
     * Getter method for subscribersTotalUniqueIvrCalls.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: activity_report.subscribers_total_unique_ivr_calls</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of subscribersTotalUniqueIvrCalls
     */
    public Integer getSubscribersTotalUniqueIvrCalls()
    {
        return subscribersTotalUniqueIvrCalls;
    }

    /**
     * Setter method for subscribersTotalUniqueIvrCalls.
     * <br>
     *
     * @param newVal the new value to be assigned to subscribersTotalUniqueIvrCalls
     */
    public void setSubscribersTotalUniqueIvrCalls(Integer newVal)
    {
        subscribersTotalUniqueIvrCalls = newVal;
    }

    /**
     * Getter method for subscribersTotalIvrCalls.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: activity_report.subscribers_total_ivr_calls</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of subscribersTotalIvrCalls
     */
    public Integer getSubscribersTotalIvrCalls()
    {
        return subscribersTotalIvrCalls;
    }

    /**
     * Setter method for subscribersTotalIvrCalls.
     * <br>
     *
     * @param newVal the new value to be assigned to subscribersTotalIvrCalls
     */
    public void setSubscribersTotalIvrCalls(Integer newVal)
    {
        subscribersTotalIvrCalls = newVal;
    }

    /**
     * Getter method for subscribersTotalIvrMinutes.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: activity_report.subscribers_total_ivr_minutes</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of subscribersTotalIvrMinutes
     */
    public Integer getSubscribersTotalIvrMinutes()
    {
        return subscribersTotalIvrMinutes;
    }

    /**
     * Setter method for subscribersTotalIvrMinutes.
     * <br>
     *
     * @param newVal the new value to be assigned to subscribersTotalIvrMinutes
     */
    public void setSubscribersTotalIvrMinutes(Integer newVal)
    {
        subscribersTotalIvrMinutes = newVal;
    }

    /**
     * Getter method for reportDate.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: activity_report.report_date</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.DATE</li>
     * </ul>
     *
     * @return the value of reportDate
     */
    public java.util.Date getReportDate()
    {
        return reportDate;
    }

    /**
     * Setter method for reportDate.
     * <br>
     *
     * @param newVal the new value to be assigned to reportDate
     */
    public void setReportDate(java.util.Date newVal)
    {
        reportDate = newVal;
    }

    /**
     * Getter method for activityReportId.
     * <br>
     * PRIMARY KEY.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: activity_report.activity_report_id</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of activityReportId
     */
    public Integer getActivityReportId()
    {
        return activityReportId;
    }

    /**
     * Setter method for activityReportId.
     * <br>
     *
     * @param newVal the new value to be assigned to activityReportId
     */
    public void setActivityReportId(Integer newVal)
    {
        activityReportId = newVal;
    }


    /**
     * Copies the passed bean into the current bean.
     *
     * @param bean the bean to copy into the current bean
     */
    public void copy(BaseActivityReportBean bean)
    {
        setNonSubscribersTotalUniqueIvrCalls(bean.getNonSubscribersTotalUniqueIvrCalls());
        setNonSubscribersTotalIvrCalls(bean.getNonSubscribersTotalIvrCalls());
        setNonSubscribersTotalIvrMinutes(bean.getNonSubscribersTotalIvrMinutes());
        setSubscribersTotalUniqueIvrCalls(bean.getSubscribersTotalUniqueIvrCalls());
        setSubscribersTotalIvrCalls(bean.getSubscribersTotalIvrCalls());
        setSubscribersTotalIvrMinutes(bean.getSubscribersTotalIvrMinutes());
        setReportDate(bean.getReportDate());
        setActivityReportId(bean.getActivityReportId());
    }

    /**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object)
	{
		if (!(object instanceof BaseActivityReportBean)) {
			return false;
		}

		BaseActivityReportBean obj = (BaseActivityReportBean) object;
		return new EqualsBuilder()
            .append(getNonSubscribersTotalUniqueIvrCalls(), obj.getNonSubscribersTotalUniqueIvrCalls())
            .append(getNonSubscribersTotalIvrCalls(), obj.getNonSubscribersTotalIvrCalls())
            .append(getNonSubscribersTotalIvrMinutes(), obj.getNonSubscribersTotalIvrMinutes())
            .append(getSubscribersTotalUniqueIvrCalls(), obj.getSubscribersTotalUniqueIvrCalls())
            .append(getSubscribersTotalIvrCalls(), obj.getSubscribersTotalIvrCalls())
            .append(getSubscribersTotalIvrMinutes(), obj.getSubscribersTotalIvrMinutes())
            .append(getReportDate(), obj.getReportDate())
            .append(getActivityReportId(), obj.getActivityReportId())
            .isEquals();
	}


    /**
     * Converts the current object to full form of the bean which includes all utility methods as well
     */
    public ActivityReportBean toManagedBean()
    {
	ActivityReportBean bean = ActivityReportManagerImpl.getInstance().createActivityReportBean();
        bean.setNonSubscribersTotalUniqueIvrCalls(getNonSubscribersTotalUniqueIvrCalls());
        bean.setNonSubscribersTotalIvrCalls(getNonSubscribersTotalIvrCalls());
        bean.setNonSubscribersTotalIvrMinutes(getNonSubscribersTotalIvrMinutes());
        bean.setSubscribersTotalUniqueIvrCalls(getSubscribersTotalUniqueIvrCalls());
        bean.setSubscribersTotalIvrCalls(getSubscribersTotalIvrCalls());
        bean.setSubscribersTotalIvrMinutes(getSubscribersTotalIvrMinutes());
        bean.setReportDate(getReportDate());
        bean.setActivityReportId(getActivityReportId());
	return bean;
    }
}