package uk.co.planetbeyond.service.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ammad
 *
 */
public class ServiceUtils
{

	private static Logger log = LoggerFactory.getLogger(ServiceUtils.class);

	/**
	 * Logs incoming AGI Call.
	 * 
	 * @param msisdn
	 * @param uniqueId
	 * @param agiCall
	 */
	public static void logIncomingRequest(String msisdn, String uniqueId, String agiCall)
	{
		log.info("Agi Request Received MSISDN:{} | UniqueId:{} | AgiCall:{}", new Object[] { msisdn, uniqueId, agiCall });
	}
}
