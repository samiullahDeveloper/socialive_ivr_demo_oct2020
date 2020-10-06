package uk.co.planetbeyond.service.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.planetbeyond.fastagi.DefaultAgiServer;
import uk.co.planetbeyond.service.poller.PollingManager;
import uk.co.planetbeyond.service.quartz.QuartzScheduler;

public class Stopper
{
	private static final Logger log = LoggerFactory.getLogger(Stopper.class);

	public static void main(String[] args)
	{
		stop();
	}

	public static void stop()
	{
		try
		{
			DefaultAgiServer.getInstance().shutdown();
			QuartzScheduler.shutdown();
			PollingManager.shutdown();
		}
		catch (Exception e)
		{
			log.error(e.toString(), e);
		}
	}
}
