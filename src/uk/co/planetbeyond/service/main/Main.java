package uk.co.planetbeyond.service.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.planetbeyond.fastagi.DefaultAgiServer;
import uk.co.planetbeyond.service.poller.PollingManager;
import uk.co.planetbeyond.service.quartz.QuartzScheduler;

public class Main
{
	static private Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args)
	{
		try
		{
			DefaultAgiServer.getInstance().defaultNewThread();

			QuartzScheduler.startScheduler();
			PollingManager.startPollingManager();
		}
		catch (Exception e)
		{
			log.error(e.getMessage(), e);
		}
	}
}
