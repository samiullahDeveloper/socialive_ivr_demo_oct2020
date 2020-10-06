package uk.co.planetbeyond.service.poller;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.planetbeyond.generated.CategoryBean;
import uk.co.planetbeyond.generated.ContentBean;
import uk.co.planetbeyond.generated.exception.DAOException;
import uk.co.planetbeyond.manager.CategoryManagerImpl;
import uk.co.planetbeyond.manager.ContentManagerImpl;
import uk.co.planetbeyond.service.constants.Constants;
import uk.co.planetbeyond.util.StringUtil;
import uk.co.planetbeyond.util.ThroughputManager;
import uk.co.planetbeyond.util.poller.CustomPollerThread;

public class ContentFileSynchronizationPoller extends CustomPollerThread
{
	private static Logger log = LoggerFactory.getLogger(ContentFileSynchronizationPoller.class);
	public static final String name = ContentFileSynchronizationPoller.class.getSimpleName();

	ThroughputManager throughputManager = new ThroughputManager(Constants.get().THROUGHPUT_PER_SECOND_FOR_CONTENT_FILE_SYNCHRONIZATION_POLLER);

	public ContentFileSynchronizationPoller()
	{
		super(name, Constants.get().CONTENT_FILE_SYNCHRONIZATION_POLLER_INTERVAL_IN_SEC * 1000);
	}

	@Override
	public void poll()
	{
		try
		{
			List<ContentBean> listOfContentFiles = ContentManagerImpl.getInstance().loadByPreparedStatementAsList("WHERE status = ? ORDER BY creation_timestamp", new Object[] { Constants.CONTENT_FILE_STATUS_ADDED }, null);

			if (listOfContentFiles == null || listOfContentFiles.size() < 1)
			{
				// no entries found
				log.debug("No content file found to synchronize.");
				return;
			}

			log.info("Content files found to synchronize. Total content files: {}", listOfContentFiles.size());

			for (ContentBean bean : listOfContentFiles)
			{
				copyContentFile(bean);

				bean.setStatus(Constants.CONTENT_FILE_STATUS_ACTIVE);
				bean.setSynchronizationTimestamp(new Date());
				bean.update();
			}
		}
		catch (Throwable e)
		{
			log.error(e.toString(), e);
		}
	}

	/**
	 * copies the ivr content file from one location to another category folder
	 * 
	 * @param bean
	 * @throws DAOException
	 */
	private void copyContentFile(ContentBean bean) throws DAOException
	{
		try
		{
			String fileName = bean.getFilename();

			File sourceFile = new File(Constants.get().CONTENT_FILE_SOURCE_PATH + fileName);

			String fileUploadPath = getCategoryWiseFileUploadPath(bean.getCategoryId());

			File destinationFile = new File(fileUploadPath + fileName);

			FileUtils.copyFile(sourceFile, destinationFile);
		}
		catch (Throwable e)
		{
			log.error(e.toString(), e);
		}
	}

	/**
	 * replaces the category folder name in CONTENT_FILE_SYNC_PATH and returns the Ivr content file path to upload/copy/sync
	 * 
	 * @param categoryId
	 * @return
	 * @throws DAOException
	 */
	private String getCategoryWiseFileUploadPath(Integer categoryId) throws DAOException
	{
		CategoryBean categoryBean = CategoryManagerImpl.getInstance().loadByPrimaryKey(categoryId);

		return StringUtil.replaceAll(Constants.get().CONTENT_FILE_SYNC_PATH, "#category#", categoryBean.getContentFolder());
	}

	@Override
	protected void shutdownCustom()
	{

	}

	public static void main(String[] args)
	{
		ContentFileSynchronizationPoller ivr = new ContentFileSynchronizationPoller();

		ivr.poll();
	}
}
