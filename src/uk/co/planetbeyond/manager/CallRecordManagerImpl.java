
// ______________________________________________________
// Generated by sql2java - http://sql2java.sourceforge.net/
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
//
// Author: Javed Kansi
// ______________________________________________________

package uk.co.planetbeyond.manager;

import java.util.Date;

import uk.co.planetbeyond.generated.CallRecordBean;
import uk.co.planetbeyond.generated.CallRecordManager;
import uk.co.planetbeyond.generated.exception.DAOException;
import uk.co.planetbeyond.managedbean.CallRecordManagedBean;
import uk.co.planetbeyond.service.constants.Constants;

/**
 * If any change needs to be made to the CallRecordManager, it MUST not be made directly Instead the CallRecordManagerImpl class should be used to
 * make the changes
 */
public class CallRecordManagerImpl extends CallRecordManager
{
	/**
	 * Singleton instance of this class
	 */
	private static CallRecordManagerImpl singleton = new CallRecordManagerImpl();

	/**
	 * Make the constructor private to make the class singleton
	 */
	private CallRecordManagerImpl()
	{
		super();

		// set the singleton instance of CallRecordManagerImpl class in the CallRecordManager so that
		// CallRecordManager.getInstance() also points to the singleton instance of CallRecordManagerImpl
		setInstance(this);
	}

	/**
	 * To make the singleton instance available to external classes
	 */
	public static CallRecordManagerImpl getInstance()
	{
		return singleton;
	}

	/**
	 * Override this method so that it returns an instance of CallRecordManagedBean instead of CallRecordBean
	 */
	@Override
	public CallRecordBean createCallRecordBean()
	{
		return new CallRecordManagedBean();
	}

	/**
	 * @param msisdn
	 * @return
	 * @throws DAOException
	 */
	public Integer saveIncomingCall(String msisdn) throws DAOException
	{
		CallRecordBean callRecord = new CallRecordBean();
		String shortCode = Constants.get().SHORT_CODE;

		callRecord.setShortcode(shortCode);
		callRecord.setMsisdn(msisdn);
		callRecord.setStartTimestamp(new Date().getTime());

		callRecord.save();

		return callRecord.getCallRecordId();
	}

	/**
	 * <p>
	 * Updates incoming IVR call duration and end time in DB
	 * </p>
	 * 
	 * @param callRecordId
	 * @throws DAOException
	 */
	public void updateIncomingCallRecord(Integer callRecordId) throws DAOException
	{
		CallRecordBean callRecord = CallRecordManagerImpl.getInstance().loadByPrimaryKey(callRecordId);

		callRecord.setEndTimestamp(new Date().getTime());

		// (end time in mills - start time in mills) / 1000
		long callDurationInSeconds = (callRecord.getEndTimestamp().getTime() - callRecord.getStartTimestamp().getTime()) / Constants.THOUSAND;

		callRecord.setDuration(Math.toIntExact(callDurationInSeconds));
		callRecord.update();
	}
}
