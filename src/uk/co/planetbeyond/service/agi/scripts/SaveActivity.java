package uk.co.planetbeyond.service.agi.scripts;

import org.apache.log4j.Logger;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;

import uk.co.planetbeyond.fastagi.SimpleAgiScript;
import uk.co.planetbeyond.manager.ActivityManagerImpl;
import uk.co.planetbeyond.manager.CallRecordManagerImpl;
import uk.co.planetbeyond.service.constants.DialplanConstants;
import uk.co.planetbeyond.util.StringUtil;

public class SaveActivity extends SimpleAgiScript
{
	private static final Logger log = Logger.getLogger(SaveActivity.class);

	@Override
	public void service(AgiRequest request, AgiChannel channel, String msisdn, String uniqueId) throws AgiException
	{
		try
		{
			Integer callRecordId = getCallerId(channel);

			if (callRecordId != null)
			{
				CallRecordManagerImpl.getInstance().updateIncomingCallRecord(callRecordId);
			}

			Integer activityCounter = StringUtil.getInteger(channel.getVariable("ACTIVITY_COUNTER"));

			for (Integer i = 0; i < activityCounter; i++)
			{
				String context = channel.getVariable("CONTEXT_NAME_" + i.toString());
				String activityName = channel.getVariable("ACTIVITY_NAME_" + i.toString());
				Integer duration = StringUtil.getInteger(channel.getVariable("DIFF_" + i.toString()), 0);
				String dtmf = channel.getVariable("SEGMENT_TRACKING_DTMF_" + i.toString());

				ActivityManagerImpl.getInstance().saveCallActivity(msisdn, uniqueId, context, activityName, duration, dtmf);
			}
			// TODO start transaction and end transaction for optimization
		}
		catch (Exception e)
		{
			log.error("Exception MSISDN:" + msisdn + " | UniqueID:" + uniqueId + " | Error:" + e.getMessage(), e);
		}
	}

	/**
	 * @param channel
	 * @return Integer callRecordId from channel variable // first saving call record end time and call duration in call_record table in DB
	 * @throws AgiException
	 */
	private Integer getCallerId(AgiChannel channel) throws AgiException
	{
		Integer callRecordId = null;
		if (!channel.getVariable(DialplanConstants.CALL_RECORD_ID).equals(""))
		{
			callRecordId = Integer.parseInt(channel.getVariable(DialplanConstants.CALL_RECORD_ID));
		}
		return callRecordId;
	}
}
