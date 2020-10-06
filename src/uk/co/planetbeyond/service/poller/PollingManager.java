package uk.co.planetbeyond.service.poller;

import java.util.ArrayList;
import java.util.List;

import uk.co.planetbeyond.util.poller.CustomPollerThread;

public class PollingManager
{
	private static List<CustomPollerThread> pollers = new ArrayList<CustomPollerThread>();

	public static void startPollingManager()
	{
		pollers.add(new ContentFileSynchronizationPoller());

		// start pollers
		startPollers();
	}

	private static void startPollers()
	{
		for (CustomPollerThread poller : pollers)
		{
			poller.start();
		}
	}

	public static void shutdown()
	{
		for (CustomPollerThread poller : pollers)
		{
			poller.shutdown();
		}
	}
}
