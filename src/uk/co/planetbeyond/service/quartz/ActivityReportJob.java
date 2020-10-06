package uk.co.planetbeyond.service.quartz;

import org.joda.time.DateTime;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.planetbeyond.generated.ActivityReportBean;
import uk.co.planetbeyond.generated.ConnectionProfile;
import uk.co.planetbeyond.generated.Manager;
import uk.co.planetbeyond.generated.SegmentReportBean;
import uk.co.planetbeyond.managedbean.ActivityReportManagedBean;
import uk.co.planetbeyond.manager.ActivityReportManagerImpl;
import uk.co.planetbeyond.service.constants.Constants;

public class ActivityReportJob implements Job
{
	private Logger log = LoggerFactory.getLogger(ActivityReportJob.class);

	@Override
	public void execute(JobExecutionContext jContext) throws JobExecutionException
	{
		try
		{
			log.info("Executing activity report job...");

			// get the activity report bean for the previous date
			ActivityReportBean report = ActivityReportManagerImpl.getInstance().getReportBean(DateTime.now().minusDays(1).toDate());

			// this must not happen as the activity_report record of the previous day has already been made by StatsCollector (real time)
			if (report == null)
			{
				log.error("No entry found in activity report for previous day. Unable to calculate all stats.");
				report = createReportBeanForPreviousDay();
			}

			// saving subscribers and non-subscribers stats in activity_report table
			saveSubscribersIvrCallsStats(report);
			saveNonSubscribersIvrCallsStats(report);

			// saving subscribers segment tracking stats in segment_report table
			saveSegmentTrackingStats(report.getReportDate());

			log.info("Activity report job complete. Stats updated: {}", report.toString());
		}
		catch (Throwable e)
		{
			log.error(e.toString(), e);
		}
	}

	/**
	 * gets and saves subscribers ivr activity stats in activity report table
	 * 
	 * @param report
	 */
	private void saveSubscribersIvrCallsStats(ActivityReportBean report)
	{
		ConnectionProfile cp = null;

		try
		{
			cp = Manager.getInstance().executeQueryByPreparedStatement("SELECT SUM(duration)/60 AS total_call_minutes, COUNT(call_record.msisdn) AS total_calls, COUNT(DISTINCT(call_record.msisdn)) AS total_unique_calls FROM call_record INNER JOIN subscriber ON call_record.msisdn = subscriber.msisdn WHERE DATE(end_timestamp)= DATE(CURRENT_DATE - INTERVAL 1 DAY) AND status = ?",
					new Object[] { Constants.SUBSCRIBER_STATUS_ACTIVE });

			if (cp.getResultSet().next())
			{
				// converting string to double, then taking ceil so that we will get the round off value of minutes in integer
				Integer totalCallMinutes = (int) Math.ceil(Double.parseDouble(cp.getResultSet().getString("total_call_minutes")));

				report.setSubscribersTotalIvrMinutes(totalCallMinutes);
				report.setSubscribersTotalIvrCalls(Integer.parseInt(cp.getResultSet().getString("total_calls")));
				report.setSubscribersTotalUniqueIvrCalls(Integer.parseInt(cp.getResultSet().getString("total_unique_calls")));
				report.save();
			}
		}
		catch (Throwable throwable)
		{
			log.info("Error retriving subscribers IVR activity report stats." + throwable.toString(), throwable);
		}
		finally
		{
			Manager.getInstance().close(cp);
		}
	}

	/**
	 * gets and saves non subscribers ivr activity stats in activity report table
	 * 
	 * @param report
	 */
	private void saveNonSubscribersIvrCallsStats(ActivityReportBean report)
	{
		ConnectionProfile cp = null;

		try
		{
			cp = Manager.getInstance().executeQueryByPreparedStatement(
					"SELECT SUM(duration)/60 AS total_call_minutes, COUNT(call_record.msisdn) AS total_calls, COUNT(DISTINCT(call_record.msisdn)) AS total_unique_calls FROM call_record LEFT JOIN subscriber ON call_record.msisdn = subscriber.msisdn WHERE DATE(end_timestamp)= DATE(CURRENT_DATE - INTERVAL 1 DAY) AND (subscriber.msisdn IS NULL OR status != ?)",
					new Object[] { Constants.SUBSCRIBER_STATUS_ACTIVE });

			if (cp.getResultSet().next())
			{
				// converting string to double, then taking ceil so that we will get the round off value of minutes in integer
				Integer totalCallMinutes = (int) Math.ceil(Double.parseDouble((cp.getResultSet().getString("total_call_minutes"))));

				report.setNonSubscribersTotalIvrMinutes(totalCallMinutes);
				report.setNonSubscribersTotalIvrCalls(Integer.parseInt(cp.getResultSet().getString("total_calls")));
				report.setNonSubscribersTotalUniqueIvrCalls(Integer.parseInt(cp.getResultSet().getString("total_unique_calls")));
				report.save();
			}
		}
		catch (Throwable throwable)
		{
			log.info("Error retriving non subscribers IVR activity report stats." + throwable.toString(), throwable);
		}
		finally
		{
			Manager.getInstance().close(cp);
		}
	}

	/**
	 * gets and saves subscribers ivr segment listening stats in segment report table
	 * 
	 * @param report
	 */
	private void saveSegmentTrackingStats(java.util.Date activityReportDate)
	{
		ConnectionProfile cp = null;

		try
		{
			cp = Manager.getInstance().executeQueryByPreparedStatement(
					"SELECT activity_name, COUNT(activity_name) AS total_hits, COUNT(DISTINCT(activity.msisdn)) AS total_unique_hits, SUM(duration) AS hits_duration FROM activity INNER JOIN subscriber ON activity.msisdn = subscriber.msisdn WHERE DATE(activity.creation_timestamp) = DATE(CURRENT_DATE - INTERVAL 1 DAY) AND status = ? GROUP BY activity_name",
					new Object[] { Constants.SUBSCRIBER_STATUS_ACTIVE });

			while (cp.getResultSet().next())
			{
				SegmentReportBean segmentReport = new SegmentReportBean();

				segmentReport.setReportDate(activityReportDate);
				segmentReport.setSegmentName((cp.getResultSet().getString("activity_name")));
				segmentReport.setSegmentHits(Integer.parseInt(cp.getResultSet().getString("total_hits")));
				segmentReport.setSegmentUniqueHits(Integer.parseInt(cp.getResultSet().getString("total_unique_hits")));
				segmentReport.setSegmentHitsDuration(Integer.parseInt(cp.getResultSet().getString("hits_duration")));
				segmentReport.save();
			}
		}
		catch (Throwable throwable)
		{
			log.info("Error retriving IVR segment tracking stats." + throwable.toString(), throwable);
		}
		finally
		{
			Manager.getInstance().close(cp);
		}
	}

	/**
	 * Creates a activity report bean for previous day with all stats set to 0
	 * 
	 * @return
	 */
	private ActivityReportBean createReportBeanForPreviousDay()
	{
		ActivityReportBean report;
		report = ActivityReportManagedBean.newInstance();
		report.setReportDate(DateTime.now().minusDays(1).toDate());

		return report;
	}

	public static void main(String a[]) throws JobExecutionException
	{
		new ActivityReportJob().execute(null);
	}
}