package uk.co.planetbeyond.service.agi.scripts;

import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.planetbeyond.fastagi.SimpleAgiScript;
import uk.co.planetbeyond.manager.SubscriberManagerImpl;
import uk.co.planetbeyond.service.constants.Constants;
import uk.co.planetbeyond.service.constants.DialplanConstants;
import uk.co.planetbeyond.service.util.ServiceUtils;
import uk.co.planetbeyond.service.util.SubscriptionWebServiceUtils;

public class SubscribeUser extends SimpleAgiScript
{
	private static final Logger log = LoggerFactory.getLogger(GetContentFiles.class);

	@Override
	public void service(AgiRequest request, AgiChannel channel, String msisdn, String uniqueId) throws AgiException
	{
		try
		{
			ServiceUtils.logIncomingRequest(msisdn, uniqueId, SubscribeUser.class.getName());

			// BY default user is not a subscriber
			channel.setVariable(DialplanConstants.IS_SUBSCRIBED, DialplanConstants.FALSE);

			// isSubscribedThroughOBD == "true" / "false"
			String isSubscribedThroughObd = channel.getVariable(DialplanConstants.IS_SUBSCRIBED_THROUGH_OBD);

			String isSubscribedThroughObdParam = (DialplanConstants.TRUE.equals(isSubscribedThroughObd)) ? Constants.get().PARAM_SUBSCRIBED_THROUGH_OBD_VALUE : Constants.get().PARAM_SUBSCRIBED_NOT_THROUGH_OBD_VALUE;

			// Calling web service
			Boolean isSubscribed = SubscriptionWebServiceUtils.subscriberUser(msisdn, uniqueId, isSubscribedThroughObdParam);

			if (isSubscribed)
			{
				SubscriberManagerImpl.getInstance().addSubscriber(msisdn, Constants.get().SUBSCRIBER_DEFAULT_LANGUAGE, Constants.CREATED_THROUGH_IVR);
				channel.setVariable(DialplanConstants.IS_SUBSCRIBED, DialplanConstants.TRUE);
			}
		}
		catch (Exception e)
		{
			log.error("Exception MSISDN:" + msisdn + " | UniqueID:" + uniqueId + " | Error:" + e.getMessage(), e);
		}
	}
}
