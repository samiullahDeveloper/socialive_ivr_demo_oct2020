package uk.co.planetbeyond.service.constants;

import uk.co.planetbeyond.util.CustomResourceBundle;

public class Constants extends CustomResourceBundle
{
	public Constants()
	{
		super("service");
	}

	private static Constants instance = null;

	public static synchronized Constants get()
	{
		if (instance == null || instance.reloadProperties())
		{
			instance = new Constants();
		}

		return instance;
	}

	public final String SHORT_CODE = getString("SHORT_CODE");
	public final String SUBSCRIBER_DEFAULT_LANGUAGE = getString("SUBSCRIBER_DEFAULT_LANGUAGE");

	public static final Integer SUBSCRIBER_STATUS_ACTIVE = 1;
	public static final Integer SUBSCRIBER_STATUS_INACTIVE = 0;

	public static final Integer CREATED_THROUGH_SMS = 1;
	public static final Integer CREATED_THROUGH_IVR = 2;

	// content files statuses
	public static final Integer CONTENT_FILE_STATUS_ADDED = 0;
	public static final Integer CONTENT_FILE_STATUS_ACTIVE = 1;
	public static final Integer CONTENT_FILE_STATUS_INACTIVE = 2;
	public static final Integer CONTENT_FILE_STATUS_DELETED = 3;

	public static final Integer THOUSAND = 1000;

	public static final String EMPTY_STRING = "";
	public static final String DOT_WAV_FILE_EXTENSION = ".wav";

	public final String SUBSCRIBE_USER = getString("SUBSCRIBE_USER");
	public final String UNSUBSCRIBE_USER = getString("UNSUBSCRIBE_USER");
	public final String CHECK_SUBSCRIPTION = getString("CHECK_SUBSCRIPTION");

	public final String WEBSERVICE_RESPONSE_IS_SUBSCRIBER = getString("WEBSERVICE_RESPONSE_IS_SUBSCRIBER");
	public final String WEBSERVICE_RESPONSE_IS_NOT_A_SUBSCRIBER = getString("WEBSERVICE_RESPONSE_IS_NOT_A_SUBSCRIBER");

	public final String PARAM_MSISDN = getString("PARAM_MSISDN");
	public final String PARAM_SUBSCRIBED_THROUGH_OBD_KEY = getString("PARAM_SUBSCRIBED_THROUGH_OBD_KEY");
	public final String PARAM_SUBSCRIBED_THROUGH_OBD_VALUE = getString("PARAM_SUBSCRIBED_THROUGH_OBD_VALUE");
	public final String PARAM_SUBSCRIBED_NOT_THROUGH_OBD_VALUE = getString("PARAM_SUBSCRIBED_NOT_THROUGH_OBD_VALUE");

	public final String RESPONSE_CODE_DONE = getString("RESPONSE_CODE_DONE");
	public final String RESPONSE_CODE_ALREADY_DONE = getString("RESPONSE_CODE_ALREADY_DONE");

	// content files sync throughput
	public int THROUGHPUT_PER_SECOND_FOR_CONTENT_FILE_SYNCHRONIZATION_POLLER = getInteger("THROUGHPUT_PER_SECOND_FOR_CONTENT_FILE_SYNCHRONIZATION_POLLER");

	// content files sync poller interval
	public int CONTENT_FILE_SYNCHRONIZATION_POLLER_INTERVAL_IN_SEC = getInteger("CONTENT_FILE_SYNCHRONIZATION_POLLER_INTERVAL_IN_SEC");

	// content files sync path on server
	public String CONTENT_FILE_SYNC_PATH = getString("CONTENT_FILE_SYNC_PATH");

	// content files source path
	public String CONTENT_FILE_SOURCE_PATH = getString("CONTENT_FILE_SOURCE_PATH");

	// constant for activity report job cron
	public final String CRON_EXPRESSION_FOR_ACTIVITY_REPORT_JOB = getString("CRON_EXPRESSION_FOR_ACTIVITY_REPORT_JOB");
}
