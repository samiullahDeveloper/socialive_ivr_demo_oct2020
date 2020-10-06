package uk.co.planetbeyond.service.util;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.planetbeyond.comm.httpclient.DefaultHttpClient;
import uk.co.planetbeyond.comm.httpclient.Parameter;
import uk.co.planetbeyond.comm.httpclient.Response;
import uk.co.planetbeyond.service.constants.Constants;

/**
 * @author Ammad
 *
 */
public class SubscriptionWebServiceUtils
{
	private static final Logger log = LoggerFactory.getLogger(SubscriptionWebServiceUtils.class);

	/**
	 * <p>
	 * If user is registered as a subscriber returns true else returns false
	 * </p>
	 * 
	 * @param msisdn
	 * @param uniqueId
	 * @return Boolean
	 * @throws Exception
	 */
	public static Boolean checkSubscriber(String msisdn, String uniqueId) throws Exception
	{
		HashMap<String, Parameter> queryParams = new HashMap<String, Parameter>();
		queryParams.put(Constants.get().PARAM_MSISDN, new Parameter(msisdn, false));

		Response httpResponse = DefaultHttpClient.getInstance().sendRequestNow(Constants.get().CHECK_SUBSCRIPTION, queryParams);

		log.info("checkSubscriber | MSISDN : {} | UniqueID : {} |  response : {}", new Object[] { msisdn, uniqueId, httpResponse.getResponseBody() });

		// splitedResponseBodyArray[0] = is_subscribed splitedResponseBodyArray[1] = is_expired
		String isSubscribed = httpResponse.getResponseBody().trim().split(",")[0];

		// (is_subscribed == true) return true
		return Constants.get().WEBSERVICE_RESPONSE_IS_SUBSCRIBER.equals(isSubscribed);
	}

	/**
	 * <p>
	 * If subscribed successfully returns true else returns false
	 * </p>
	 * 
	 * @param msisdn
	 * @param uniqueId
	 * @param isSubscribedThroughOBD
	 * @return Boolean
	 * @throws Exception
	 */
	public static Boolean subscriberUser(String msisdn, String uniqueId, String isSubscribedThroughOBD) throws Exception
	{
		HashMap<String, Parameter> queryParams = new HashMap<String, Parameter>();
		queryParams.put(Constants.get().PARAM_MSISDN, new Parameter(msisdn, false));
		queryParams.put(Constants.get().PARAM_SUBSCRIBED_THROUGH_OBD_KEY, new Parameter(isSubscribedThroughOBD, false));

		Response httpResponse = DefaultHttpClient.getInstance().sendRequestNow(Constants.get().SUBSCRIBE_USER, queryParams);

		log.info("SubscriberUser WebService Response:{} | MSISDN : {} | UniqueID : {}", new Object[] { httpResponse.getResponseBody(), msisdn, uniqueId });

		// First Line of Response contains the information about subscription
		String response = (httpResponse.getResponseBody().trim().split("\n")[0]);

		// If Response's first character == 1 or 2 | Success | return true
		return (Constants.get().RESPONSE_CODE_DONE.equals(response) || Constants.get().RESPONSE_CODE_ALREADY_DONE.equals(response));

	}

	/**
	 * <p>
	 * If unsubscribed successfully returns true else returns false
	 * </p>
	 * 
	 * @param msisdn
	 * @param uniqueId
	 * @return Boolean
	 * @throws Exception
	 */
	public static Boolean unsubscriberUser(String msisdn, String uniqueId) throws Exception
	{
		HashMap<String, Parameter> queryParams = new HashMap<String, Parameter>();
		queryParams.put(Constants.get().PARAM_MSISDN, new Parameter(msisdn, false));
		Response httpResponse = DefaultHttpClient.getInstance().sendRequestNow(Constants.get().UNSUBSCRIBE_USER, queryParams);

		log.info("unsubscriberUser | MSISDN : {} | UniqueID : {} |  response : {}", new Object[] { msisdn, uniqueId, httpResponse.getResponseBody() });

		// First Line of Response contains the information about subscription
		String response = (httpResponse.getResponseBody().trim().split("\n")[0]);

		// If Response's first character == 1 or 2 | Success | return true
		return (Constants.get().RESPONSE_CODE_DONE.equals(response) || Constants.get().RESPONSE_CODE_ALREADY_DONE.equals(response));
	}
}
