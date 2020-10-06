package uk.co.planetbeyond.service.agi.scripts;

import java.util.List;

import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.planetbeyond.fastagi.SimpleAgiScript;
import uk.co.planetbeyond.generated.CategoryBean;
import uk.co.planetbeyond.generated.ContentBean;
import uk.co.planetbeyond.manager.CategoryManagerImpl;
import uk.co.planetbeyond.manager.ContentManagerImpl;
import uk.co.planetbeyond.service.constants.Constants;
import uk.co.planetbeyond.service.util.ServiceUtils;
import uk.co.planetbeyond.util.StringUtil;

public class GetContentFiles extends SimpleAgiScript
{
	private static final Logger log = LoggerFactory.getLogger(GetContentFiles.class);

	@Override
	public void service(AgiRequest request, AgiChannel channel, String msisdn, String uniqueId) throws AgiException
	{
		try
		{
			ServiceUtils.logIncomingRequest(msisdn, uniqueId, GetContentFiles.class.getName());

			String menuNumber = channel.getVariable("CATEGORY_MENU_NUMBER");
			Integer categoryId = 0;
			Integer totalFileCount = 0;

			CategoryBean category = CategoryManagerImpl.getInstance().loadSingleEntryByPreparedStatement("WHERE menu_number=?", new Object[] { menuNumber }, null);

			if (category == null)
			{
				channel.setVariable("TOTAL_FILES", totalFileCount.toString());
				log.info("MSISDN : {} | UniqueID : {} | Category : NOT_FOUND | User Selection : {} | Files List Size : {}", new Object[] { msisdn, uniqueId, menuNumber, totalFileCount.toString() });
				return;
			}

			categoryId = category.getCategoryId();
			channel.setVariable("CONTENT_FOLDER", category.getContentFolder());

			List<ContentBean> listOfContentFiles = ContentManagerImpl.getInstance().loadByPreparedStatementAsList("WHERE category_id=? AND status=? ORDER BY content_id DESC", new Object[] { categoryId, Constants.CONTENT_FILE_STATUS_ACTIVE }, null);

			if (listOfContentFiles != null)
			{
				totalFileCount = listOfContentFiles.size();
			}

			log.info("MSISDN : {} | UniqueID : {} | Category : {} | User Selection : {} | Files List Size : {}", new Object[] { msisdn, uniqueId, categoryId, menuNumber, totalFileCount.toString() });

			channel.setVariable("TOTAL_FILES", totalFileCount.toString());

			for (int index = 0; index < totalFileCount; index++)
			{
				ContentBean contentFile = listOfContentFiles.get(index);

				// removing ".wav" file extension from the filename because Asterisk plays file without file extension.
				String fileName = StringUtil.replaceAll(contentFile.getFilename(), Constants.DOT_WAV_FILE_EXTENSION, Constants.EMPTY_STRING);

				channel.setVariable("CONTENT_FILE_NAME_" + index, fileName);
				log.debug("index:{} : menu_number:{} | filename:{}", new Object[] { index, contentFile.getMenuNumber(), contentFile.getFilename() });
			}
		}
		catch (Throwable e)
		{
			log.error("Exception MSISDN:" + msisdn + " | UniqueID:" + uniqueId + " | Error:" + e.getMessage(), e);
		}
	}
}
