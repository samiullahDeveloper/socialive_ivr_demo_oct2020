




// ______________________________________________________
// Generated by sql2java - http://sql2java.sourceforge.net/
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
//
// Author: Javed Kansi
// ______________________________________________________

package uk.co.planetbeyond.generated;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import uk.co.planetbeyond.manager.ActivityManagerImpl;
import uk.co.planetbeyond.generated.GeneratedBean;





import uk.co.planetbeyond.generated.exception.DAOException;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.sleepycat.persist.model.Persistent;

/**
 * ActivityBean is a mapping of activity Table.
 * @author sql2java
*/
@Persistent
public class ActivityBean extends BaseActivityBean implements Serializable, GeneratedBean, JoinHelperInterface
{
	private static final long serialVersionUID = -8112894328966507224L;
	
    private boolean dtmfIsModified = false;
    private boolean dtmfIsInitialized = false;

    private boolean durationIsModified = false;
    private boolean durationIsInitialized = false;

    private boolean activityNameIsModified = false;
    private boolean activityNameIsInitialized = false;

    private boolean contextIsModified = false;
    private boolean contextIsInitialized = false;

    private boolean creationTimestampIsModified = false;
    private boolean creationTimestampIsInitialized = false;

    private boolean uniqueIdIsModified = false;
    private boolean uniqueIdIsInitialized = false;

    private boolean msisdnIsModified = false;
    private boolean msisdnIsInitialized = false;

    private boolean activityIdIsModified = false;
    private boolean activityIdIsInitialized = false;

    private boolean _isNew = true;

    /**
     * Prefered methods to create a ActivityBean is via the createActivityBean method in ActivityManager or
     * via the factory class ActivityFactory create method
     */
    public ActivityBean()
    {
    }



    /**
     * Setter method for dtmf.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to dtmf
     */
    @Override
    public void setDtmf(String newVal)
    {
        if ((newVal != null && dtmf != null && (newVal.compareTo(dtmf) == 0)) ||
            (newVal == null && dtmf == null && dtmfIsInitialized)) {
            return;
        }
        dtmf = newVal;
        dtmfIsModified = true;
        dtmfIsInitialized = true;
    }

    /**
     * Determines if the dtmf has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isDtmfModified()
    {
        return dtmfIsModified;
    }

    /**
     * Manually set whether dtmf has been modified or not.
     */
    public void isDtmfModified(boolean value)
    {
        dtmfIsModified = value;
    }	

    /**
     * Determines if the dtmf has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isDtmfInitialized()
    {
        return dtmfIsInitialized;
    }

    /**
     * Manually set whether dtmf has been initialized or not.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     */
    public void isDtmfInitialized(boolean value)
    {
        dtmfIsInitialized = value;
    }



    /**
     * Setter method for duration.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to duration
     */
    @Override
    public void setDuration(Integer newVal)
    {
        if ((newVal != null && duration != null && (newVal.compareTo(duration) == 0)) ||
            (newVal == null && duration == null && durationIsInitialized)) {
            return;
        }
        duration = newVal;
        durationIsModified = true;
        durationIsInitialized = true;
    }

    /**
     * Setter method for duration.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to duration
     */
    public void setDuration(int newVal)
    {
        setDuration(new Integer(newVal));
    }

    /**
     * Determines if the duration has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isDurationModified()
    {
        return durationIsModified;
    }

    /**
     * Manually set whether duration has been modified or not.
     */
    public void isDurationModified(boolean value)
    {
        durationIsModified = value;
    }	

    /**
     * Determines if the duration has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isDurationInitialized()
    {
        return durationIsInitialized;
    }

    /**
     * Manually set whether duration has been initialized or not.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     */
    public void isDurationInitialized(boolean value)
    {
        durationIsInitialized = value;
    }



    /**
     * Setter method for activityName.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to activityName
     */
    @Override
    public void setActivityName(String newVal)
    {
        if ((newVal != null && activityName != null && (newVal.compareTo(activityName) == 0)) ||
            (newVal == null && activityName == null && activityNameIsInitialized)) {
            return;
        }
        activityName = newVal;
        activityNameIsModified = true;
        activityNameIsInitialized = true;
    }

    /**
     * Determines if the activityName has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isActivityNameModified()
    {
        return activityNameIsModified;
    }

    /**
     * Manually set whether activityName has been modified or not.
     */
    public void isActivityNameModified(boolean value)
    {
        activityNameIsModified = value;
    }	

    /**
     * Determines if the activityName has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isActivityNameInitialized()
    {
        return activityNameIsInitialized;
    }

    /**
     * Manually set whether activityName has been initialized or not.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     */
    public void isActivityNameInitialized(boolean value)
    {
        activityNameIsInitialized = value;
    }



    /**
     * Setter method for context.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to context
     */
    @Override
    public void setContext(String newVal)
    {
        if ((newVal != null && context != null && (newVal.compareTo(context) == 0)) ||
            (newVal == null && context == null && contextIsInitialized)) {
            return;
        }
        context = newVal;
        contextIsModified = true;
        contextIsInitialized = true;
    }

    /**
     * Determines if the context has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isContextModified()
    {
        return contextIsModified;
    }

    /**
     * Manually set whether context has been modified or not.
     */
    public void isContextModified(boolean value)
    {
        contextIsModified = value;
    }	

    /**
     * Determines if the context has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isContextInitialized()
    {
        return contextIsInitialized;
    }

    /**
     * Manually set whether context has been initialized or not.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     */
    public void isContextInitialized(boolean value)
    {
        contextIsInitialized = value;
    }



    /**
     * Setter method for creationTimestamp.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to creationTimestamp
     */
    @Override
    public void setCreationTimestamp(java.util.Date newVal)
    {
        if ((newVal != null && creationTimestamp != null && (newVal.compareTo(creationTimestamp) == 0)) ||
            (newVal == null && creationTimestamp == null && creationTimestampIsInitialized)) {
            return;
        }
        creationTimestamp = newVal;
        creationTimestampIsModified = true;
        creationTimestampIsInitialized = true;
    }

    /**
     * Setter method for creationTimestamp.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to creationTimestamp
     */
    public void setCreationTimestamp(long newVal)
    {
        setCreationTimestamp(new java.util.Date(newVal));
    }

    /**
     * Determines if the creationTimestamp has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isCreationTimestampModified()
    {
        return creationTimestampIsModified;
    }

    /**
     * Manually set whether creationTimestamp has been modified or not.
     */
    public void isCreationTimestampModified(boolean value)
    {
        creationTimestampIsModified = value;
    }	

    /**
     * Determines if the creationTimestamp has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isCreationTimestampInitialized()
    {
        return creationTimestampIsInitialized;
    }

    /**
     * Manually set whether creationTimestamp has been initialized or not.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     */
    public void isCreationTimestampInitialized(boolean value)
    {
        creationTimestampIsInitialized = value;
    }



    /**
     * Setter method for uniqueId.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to uniqueId
     */
    @Override
    public void setUniqueId(String newVal)
    {
        if ((newVal != null && uniqueId != null && (newVal.compareTo(uniqueId) == 0)) ||
            (newVal == null && uniqueId == null && uniqueIdIsInitialized)) {
            return;
        }
        uniqueId = newVal;
        uniqueIdIsModified = true;
        uniqueIdIsInitialized = true;
    }

    /**
     * Determines if the uniqueId has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isUniqueIdModified()
    {
        return uniqueIdIsModified;
    }

    /**
     * Manually set whether uniqueId has been modified or not.
     */
    public void isUniqueIdModified(boolean value)
    {
        uniqueIdIsModified = value;
    }	

    /**
     * Determines if the uniqueId has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isUniqueIdInitialized()
    {
        return uniqueIdIsInitialized;
    }

    /**
     * Manually set whether uniqueId has been initialized or not.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     */
    public void isUniqueIdInitialized(boolean value)
    {
        uniqueIdIsInitialized = value;
    }



    /**
     * Setter method for msisdn.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to msisdn
     */
    @Override
    public void setMsisdn(String newVal)
    {
        if ((newVal != null && msisdn != null && (newVal.compareTo(msisdn) == 0)) ||
            (newVal == null && msisdn == null && msisdnIsInitialized)) {
            return;
        }
        msisdn = newVal;
        msisdnIsModified = true;
        msisdnIsInitialized = true;
    }

    /**
     * Determines if the msisdn has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isMsisdnModified()
    {
        return msisdnIsModified;
    }

    /**
     * Manually set whether msisdn has been modified or not.
     */
    public void isMsisdnModified(boolean value)
    {
        msisdnIsModified = value;
    }	

    /**
     * Determines if the msisdn has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isMsisdnInitialized()
    {
        return msisdnIsInitialized;
    }

    /**
     * Manually set whether msisdn has been initialized or not.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     */
    public void isMsisdnInitialized(boolean value)
    {
        msisdnIsInitialized = value;
    }



    /**
     * Setter method for activityId.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to activityId
     */
    @Override
    public void setActivityId(Integer newVal)
    {
        if ((newVal != null && activityId != null && (newVal.compareTo(activityId) == 0)) ||
            (newVal == null && activityId == null && activityIdIsInitialized)) {
            return;
        }
        activityId = newVal;
        activityIdIsModified = true;
        activityIdIsInitialized = true;
    }

    /**
     * Setter method for activityId.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to activityId
     */
    public void setActivityId(int newVal)
    {
        setActivityId(new Integer(newVal));
    }

    /**
     * Determines if the activityId has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isActivityIdModified()
    {
        return activityIdIsModified;
    }

    /**
     * Manually set whether activityId has been modified or not.
     */
    public void isActivityIdModified(boolean value)
    {
        activityIdIsModified = value;
    }	

    /**
     * Determines if the activityId has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isActivityIdInitialized()
    {
        return activityIdIsInitialized;
    }

    /**
     * Manually set whether activityId has been initialized or not.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     */
    public void isActivityIdInitialized(boolean value)
    {
        activityIdIsInitialized = value;
    }

    /**
     * Determines if the current object is new.
     *
     * @return true if the current object is new, false if the object is not new
     */
    public boolean isNew()
    {
        return _isNew;
    }

    /**
     * Specifies to the object if it has been set as new.
     *
     * @param isNew the boolean value to be assigned to the isNew field
     */
    public void isNew(boolean isNew)
    {
        this._isNew = isNew;
    }

    /**
     * Determines if the object has been modified since the last time this method was called.
     * <br>
     * We can also determine if this object has ever been modified since its creation.
     *
     * @return true if the object has been modified, false if the object has not been modified
     */
    public boolean isModified()
    {
        return dtmfIsModified 		|| durationIsModified  		|| activityNameIsModified  		|| contextIsModified  		|| creationTimestampIsModified  		|| uniqueIdIsModified  		|| msisdnIsModified  		|| activityIdIsModified  ;
    }

    /**
     * Resets the object modification status to 'not modified'.
     */
    public void resetIsModified(boolean isModified)
    {
        dtmfIsModified = isModified;
        durationIsModified = isModified;
        activityNameIsModified = isModified;
        contextIsModified = isModified;
        creationTimestampIsModified = isModified;
        uniqueIdIsModified = isModified;
        msisdnIsModified = isModified;
        activityIdIsModified = isModified;
    }

    /**
     * Copies the passed bean into the current bean.
     *
     * @param bean the bean to copy into the current bean
     */
    public void copy(ActivityBean bean)
    {
        setDtmf(bean.getDtmf());
        setDuration(bean.getDuration());
        setActivityName(bean.getActivityName());
        setContext(bean.getContext());
        setCreationTimestamp(bean.getCreationTimestamp());
        setUniqueId(bean.getUniqueId());
        setMsisdn(bean.getMsisdn());
        setActivityId(bean.getActivityId());
    }

    /**
     * Converts the current object to stripped form of the bean which only includes the properties of the bean and their getters/
     */
    public BaseActivityBean toBaseBean()
    {
	BaseActivityBean bean = new BaseActivityBean();
        bean.setDtmf(getDtmf());
        bean.setDuration(getDuration());
        bean.setActivityName(getActivityName());
        bean.setContext(getContext());
        bean.setCreationTimestamp(getCreationTimestamp());
        bean.setUniqueId(getUniqueId());
        bean.setMsisdn(getMsisdn());
        bean.setActivityId(getActivityId());
	return bean;
    }
    
    /**
     * Copies ALL properties of the passed bean into the current bean including isNew and isModified etc
     *
     * @param bean the bean to copy into the current bean
     */
    public void copyAll(ActivityBean bean)
    {
	copy(bean);
	this._isNew = bean.isNew();
	
	dtmfIsModified = bean.isDtmfModified();
  	dtmfIsInitialized= bean.isDtmfInitialized();
	durationIsModified = bean.isDurationModified();
  	durationIsInitialized= bean.isDurationInitialized();
	activityNameIsModified = bean.isActivityNameModified();
  	activityNameIsInitialized= bean.isActivityNameInitialized();
	contextIsModified = bean.isContextModified();
  	contextIsInitialized= bean.isContextInitialized();
	creationTimestampIsModified = bean.isCreationTimestampModified();
  	creationTimestampIsInitialized= bean.isCreationTimestampInitialized();
	uniqueIdIsModified = bean.isUniqueIdModified();
  	uniqueIdIsInitialized= bean.isUniqueIdInitialized();
	msisdnIsModified = bean.isMsisdnModified();
  	msisdnIsInitialized= bean.isMsisdnInitialized();
	activityIdIsModified = bean.isActivityIdModified();
  	activityIdIsInitialized= bean.isActivityIdInitialized();
    }    

    /**
     * return a dictionnary of the object
     */
    public Map<String,String> getDictionnary()
    {
        Map<String,String> dictionnary = new HashMap<String,String>();
        dictionnary.put("dtmf", getDtmf() == null ? "" : getDtmf().toString());
        dictionnary.put("duration", getDuration() == null ? "" : getDuration().toString());
        dictionnary.put("activity_name", getActivityName() == null ? "" : getActivityName().toString());
        dictionnary.put("context", getContext() == null ? "" : getContext().toString());
        dictionnary.put("creation_timestamp", getCreationTimestamp() == null ? "" : getCreationTimestamp().toString());
        dictionnary.put("unique_id", getUniqueId() == null ? "" : getUniqueId().toString());
        dictionnary.put("msisdn", getMsisdn() == null ? "" : getMsisdn().toString());
        dictionnary.put("activity_id", getActivityId() == null ? "" : getActivityId().toString());
        return dictionnary;
    }

    /**
     * return a dictionnary of the pk columns
     */
    public Map<String,String> getPkDictionnary()
    {
        Map<String,String> dictionnary = new HashMap<String,String>();
        dictionnary.put("activity_id", getActivityId() == null ? "" : getActivityId().toString());
        return dictionnary;
    }

    /**
     * return a the value string representation of the given field
     */
    public String getValue(String column)
    {
        if (null == column || "".equals(column)) {
            return "";
        } else if ("dtmf".equalsIgnoreCase(column) || "dtmf".equalsIgnoreCase(column)) {
            return getDtmf() == null ? "" : getDtmf().toString();
        } else if ("duration".equalsIgnoreCase(column) || "duration".equalsIgnoreCase(column)) {
            return getDuration() == null ? "" : getDuration().toString();
        } else if ("activity_name".equalsIgnoreCase(column) || "activityName".equalsIgnoreCase(column)) {
            return getActivityName() == null ? "" : getActivityName().toString();
        } else if ("context".equalsIgnoreCase(column) || "context".equalsIgnoreCase(column)) {
            return getContext() == null ? "" : getContext().toString();
        } else if ("creation_timestamp".equalsIgnoreCase(column) || "creationTimestamp".equalsIgnoreCase(column)) {
            return getCreationTimestamp() == null ? "" : getCreationTimestamp().toString();
        } else if ("unique_id".equalsIgnoreCase(column) || "uniqueId".equalsIgnoreCase(column)) {
            return getUniqueId() == null ? "" : getUniqueId().toString();
        } else if ("msisdn".equalsIgnoreCase(column) || "msisdn".equalsIgnoreCase(column)) {
            return getMsisdn() == null ? "" : getMsisdn().toString();
        } else if ("activity_id".equalsIgnoreCase(column) || "activityId".equalsIgnoreCase(column)) {
            return getActivityId() == null ? "" : getActivityId().toString();
        }
        return "";
    }

    /**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object)
	{
		if (!(object instanceof ActivityBean)) {
			return false;
		}

		ActivityBean obj = (ActivityBean) object;
		return new EqualsBuilder()
            .append(getDtmf(), obj.getDtmf())
            .append(getDuration(), obj.getDuration())
            .append(getActivityName(), obj.getActivityName())
            .append(getContext(), obj.getContext())
            .append(getCreationTimestamp(), obj.getCreationTimestamp())
            .append(getUniqueId(), obj.getUniqueId())
            .append(getMsisdn(), obj.getMsisdn())
            .append(getActivityId(), obj.getActivityId())
            .isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
            .append(getDtmf())
            .append(getDuration())
            .append(getActivityName())
            .append(getContext())
            .append(getCreationTimestamp())
            .append(getUniqueId())
            .append(getMsisdn())
            .append(getActivityId())
            .toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
	    return toString(ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * you can use the following styles:
	 * <li>ToStringStyle.DEFAULT_STYLE</li>
	 * <li>ToStringStyle.MULTI_LINE_STYLE</li>
     * <li>ToStringStyle.NO_FIELD_NAMES_STYLE</li>
     * <li>ToStringStyle.SHORT_PREFIX_STYLE</li>
     * <li>ToStringStyle.SIMPLE_STYLE</li>
	 */
	public String toString(ToStringStyle style) {
		return new ToStringBuilder(this, style)
            .append("dtmf", getDtmf())
            .append("duration", getDuration())
            .append("activity_name", getActivityName())
            .append("context", getContext())
            .append("creation_timestamp", getCreationTimestamp())
            .append("unique_id", getUniqueId())
            .append("msisdn", getMsisdn())
            .append("activity_id", getActivityId())
            .toString();
	}


    public int compareTo(Object object)
    {
        ActivityBean obj = (ActivityBean) object;
        return new CompareToBuilder()
            .append(getDtmf(), obj.getDtmf())
            .append(getDuration(), obj.getDuration())
            .append(getActivityName(), obj.getActivityName())
            .append(getContext(), obj.getContext())
            .append(getCreationTimestamp(), obj.getCreationTimestamp())
            .append(getUniqueId(), obj.getUniqueId())
            .append(getMsisdn(), obj.getMsisdn())
            .append(getActivityId(), obj.getActivityId())
            .toComparison();
   }






    //_____________________________________________________________________
    //

    // SAVE
    //_____________________________________________________________________
    /**
     * Saves the ActivityBean bean into the database.
     *
     * @return the inserted or updated bean
     * @throws DAOException
     */
    //12
    public ActivityBean save() throws DAOException
    {
        return ActivityManagerImpl.getInstance().save(this);
    }

    /**
     * Update the ActivityBean bean record in the database according to the changes.
     *
     * @return the updated bean
     * @throws DAOException
     */
    //14
    public ActivityBean update() throws DAOException
    {
        return ActivityManagerImpl.getInstance().update(this);
    }

    /**
     * Inserts the ActivityBean bean record in the database.
     *
     * @return the updated bean
     * @throws DAOException
     */
    //15
    public ActivityBean insert() throws DAOException
    {
        return ActivityManagerImpl.getInstance().insert(this);
    }

    /**
     * Creates and returns a new instance of ActivityBean.
     *
     * @return
     */
    //15
    public BaseGeneratedBean newBaseInstance()
    {
        return ActivityManagerImpl.getInstance().createActivityBean();
    }

    /**
     * Creates and returns a new instance of ActivityBean.
     *
     * @return
     */
    //15
    public static ActivityBean newInstance()
    {
        return ActivityManagerImpl.getInstance().createActivityBean();
    }

    /**
     * Returns manager class for Activity
     *
     * @return
     */
    //15
    public BaseGeneratedManager getBaseManager()
    {
        return ActivityManagerImpl.getInstance();
    }

    /**
     * Returns name of the corresponding table i.e. Activity
     *
     * @return
     */
    //15
    public String getTableName()
    {
        return "activity";
    }



}
