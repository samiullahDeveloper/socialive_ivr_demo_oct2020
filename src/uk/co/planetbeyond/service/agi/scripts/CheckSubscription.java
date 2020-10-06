package uk.co.planetbeyond.service.agi.scripts;

import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.planetbeyond.fastagi.SimpleAgiScript;
import uk.co.planetbeyond.generated.SubscriberBean;
import uk.co.planetbeyond.manager.CallRecordManagerImpl;
import uk.co.planetbeyond.manager.SubscriberManagerImpl;
import uk.co.planetbeyond.service.constants.DialplanConstants;
import uk.co.planetbeyond.service.util.ServiceUtils;
import uk.co.planetbeyond.service.util.SubscriptionWebServiceUtils;

public class CheckSubscription extends SimpleAgiScript
{

	private static final Logger log = LoggerFactory.getLogger(CheckSubscription.class);

	@Override
	public void service(AgiRequest request, AgiChannel channel, String msisdn, String uniqueId) throws AgiException
	{
		try
		{
			ServiceUtils.logIncomingRequest(msisdn, uniqueId, GetContentFiles.class.getName());

			// Saving CDR
			Integer callRecordId = CallRecordManagerImpl.getInstance().saveIncomingCall(msisdn);
			channel.setVariable(DialplanConstants.CALL_RECORD_ID, (callRecordId != null) ? callRecordId.toString() : "");

			// Setting IS_SUBSCRIBED as false in the beginning
			channel.setVariable(DialplanConstants.IS_SUBSCRIBED, DialplanConstants.FALSE);

			// Getting default value of language set in dial plan
			String language = channel.getVariable(DialplanConstants.LANGUAGE);

			// Calling check subscriber web service
			Boolean isSubscriber = SubscriptionWebServiceUtils.checkSubscriber(msisdn, uniqueId);

			// not a subscriber and returning without setting IS_SUBSCRIBED flag as true
			if (!isSubscriber)
			{
				SubscriberManagerImpl.getInstance().deactivateSubscriber(msisdn);
				return;
			}

			// Returns Subscriber if found in IVR service database, else save it in IVR serivce's database and return its instance When User is
			// returned as
			// subscriber by web service and not stored in IVR service own database.
			// Then Created through is set as SMS to save the record in IVR service's database
			SubscriberBean subscriber = SubscriberManagerImpl.getInstance().getAndSaveSubscriber(msisdn, language);

			channel.setVariable(DialplanConstants.LANGUAGE, subscriber.getLanguage());
			channel.setVariable(DialplanConstants.IS_SUBSCRIBED, DialplanConstants.TRUE);

		}
		catch (Exception e)
		{
			log.error("Exception MSISDN:" + msisdn + " | UniqueID:" + uniqueId + " | Error:" + e.getMessage(), e);
		}
	}
}
