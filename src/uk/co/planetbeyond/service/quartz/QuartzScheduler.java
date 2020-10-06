package uk.co.planetbeyond.service.quartz;

import java.text.ParseException;
import java.util.Date;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.planetbeyond.service.constants.Constants;

public class QuartzScheduler
{
	private static Logger log = LoggerFactory.getLogger(QuartzScheduler.class);
	private static Scheduler scheduler;

	public static void startScheduler()
	{
		try
		{
			// Initiate a Schedule Factory
			SchedulerFactory schedulerFactory = new StdSchedulerFactory();

			// Retrieve a scheduler from schedule factory
			scheduler = schedulerFactory.getScheduler();

			scheduleCronJob("ActivityReportJob", Constants.get().CRON_EXPRESSION_FOR_ACTIVITY_REPORT_JOB, ActivityReportJob.class, false);

			// start the scheduler
			scheduler.start();
		}
		catch (Throwable e)
		{
			log.error(e.toString(), e);
		}
	}

	@SuppressWarnings("unused")
	private static void scheduleSimpleJob(String name, long repeatIntervalInMilliSeconds, Class<?> jobClass) throws SchedulerException, ParseException
	{
		// Initiate JobDetail with job name, and executable job class
		JobDetail jobDetail = new JobDetail(name + "JobDetail", jobClass);

		SimpleTrigger simpleTrigger = new SimpleTrigger(name + "Trigger", SimpleTrigger.REPEAT_INDEFINITELY, repeatIntervalInMilliSeconds);

		// schedule a job with JobDetail and Trigger
		log.info("Scheduling {} job. Repeat interval {} ms : next execution will be on {}...", new Object[] { name, repeatIntervalInMilliSeconds, simpleTrigger.getFireTimeAfter(new Date()) });
		scheduler.scheduleJob(jobDetail, simpleTrigger);
	}

	/**
	 * 
	 * @param name
	 * @param cronExpression
	 * @param jobClass
	 * @param useRescheduleFunction
	 * @param groupName
	 * @throws SchedulerException
	 * @throws ParseException
	 */
	private static void scheduleCronJob(String name, String cronExpression, Class<?> jobClass, boolean useRescheduleFunction) throws SchedulerException, ParseException
	{
		// Initiate JobDetail with job name, and executable job class
		JobDetail jobDetail = new JobDetail(name, null, jobClass);

		// Initiate CronTrigger with its name
		CronTrigger trigger = new CronTrigger(name + "Trigger", "TriggerGroup", name, null);

		// setup CronExpression
		CronExpression cronexp = new CronExpression(cronExpression);

		// Assign the CronExpression to CronTrigger
		trigger.setCronExpression(cronexp);

		if (useRescheduleFunction)
		{
			// reschedule a job having given trigger name and trigger group name, with new trigger
			log.info("Rescheduling already scheduled job={} | cronexpression={} | next execution will be on {}...", new Object[] { name, cronExpression, cronexp.getNextValidTimeAfter(new Date()) });
			scheduler.rescheduleJob(trigger.getName(), trigger.getGroup(), trigger);
		}
		else
		{
			// schedule a job with JobDetail and Trigger
			log.info("Scheduling job={} | cronexpression={} | next execution will be on {}...", new Object[] { name, cronExpression, cronexp.getNextValidTimeAfter(new Date()) });
			scheduler.scheduleJob(jobDetail, trigger);
		}
	}

	public static void shutdown()
	{
		if (scheduler != null)
		{
			try
			{
				scheduler.shutdown();
			}
			catch (Throwable e)
			{
				log.error(e.toString(), e);
			}
		}
	}

}
