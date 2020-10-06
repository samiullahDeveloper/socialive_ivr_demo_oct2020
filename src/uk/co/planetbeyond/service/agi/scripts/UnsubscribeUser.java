package uk.co.planetbeyond.service.agi.scripts;

import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.planetbeyond.fastagi.SimpleAgiScript;
import uk.co.planetbeyond.generated.Manager;
import uk.co.planetbeyond.service.constants.Constants;
import uk.co.planetbeyond.service.constants.DialplanConstants;
import uk.co.planetbeyond.service.util.ServiceUtils;
import uk.co.planetbeyond.service.util.SubscriptionWebServiceUtils;

public class UnsubscribeUser extends SimpleAgiScript
{
	private static final Logger log = LoggerFactory.getLogger(UnsubscribeUser.class);

	@Override
	public void service(AgiRequest request, AgiChannel channel, String msisdn, String uniqueId) throws AgiException
	{
		try
		{
			ServiceUtils.logIncomingRequest(msisdn, uniqueId, UnsubscribeUser.class.getName());

			Boolean isUnsubscribed = SubscriptionWebServiceUtils.unsubscriberUser(msisdn, uniqueId);

			if (!isUnsubscribed)
			{
				log.info("User Not Unsubscribed successfully MSISDN:" + msisdn + " | UniqueID:" + uniqueId);
				return;
			}

			Manager.getInstance().executeUpdateQueryByPreparedStatement("UPDATE subscriber SET status =?, unsubscription_timestamp = NOW() WHERE msisdn=?", new Object[] { Constants.SUBSCRIBER_STATUS_INACTIVE, msisdn });

			channel.setVariable(DialplanConstants.IS_SUBSCRIBED, DialplanConstants.FALSE);
			channel.setVariable(DialplanConstants.IS_UNSUBSCRIBED, DialplanConstants.TRUE);

			log.info("User Unsubscribed MSISDN:" + msisdn + " | UniqueId:" + uniqueId);
		}
		catch (Exception e)
		{
			log.error("Exception MSISDN:" + msisdn + " | UniqueID:" + uniqueId + " | Error:" + e.getMessage(), e);
		}
	}
}
