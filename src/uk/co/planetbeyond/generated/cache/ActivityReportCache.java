




// ______________________________________________________
// Generated by sql2java - http://sql2java.sourceforge.net/
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
//
// Author: Javed Kansi
// ______________________________________________________

package uk.co.planetbeyond.generated.cache;

import java.util.HashMap;

import uk.co.planetbeyond.generated.exception.DAOException;
import uk.co.planetbeyond.generated.ActivityReportBean;
import uk.co.planetbeyond.manager.ActivityReportManagerImpl;

/**
 * This cache manager is based on code from Mark GRAND in "Patterns in Java,
 * Volume 1", Wiley.
 * 
 * @author afagot
 */
public final class ActivityReportCache 
{
	/**
	 * Unique instance of the cache manager.
	 */
	private static ActivityReportCache instance = new ActivityReportCache();

	/**
	 * Maximum number of ActivityReportBean objects that may be in the cache.
	 */
	private int maxCacheSize = 80;

	/**
	 * The number of ActivityReportBean objects currently in the cache.
	 */
	private int currentCacheSize = 0;

	/**
	 * We use a linked list to determine the least recently used bean. The cache
	 * is implemented by a HashMap object. The HashMap values are linked list
	 * objects that refer to the actual ActivityReportBean.
	 */
	private HashMap<Integer, LinkedList> cache = new HashMap<Integer, LinkedList>();

	/**
	 * This is the head of the linked list that refers to the most recently used
	 * ActivityReportBean.
	 */
	private LinkedList mru;

	/**
	 * This is the end of the linked list that refers to the least recently used
	 * ActivityReportBean.
	 */
	private LinkedList lru;
	
	/**
	* Object to make updates in this class sychronized
	*/
	private Object updateLock = new Object();
	
	/**
	 * In order to prevent the compiler from generating the default constructor.
	 */
	private ActivityReportCache() 
	{
	}

	/**
	* Max Number of entries that can be saved in the cache at a time
	*
	* @param maxCacheSize
	*/
	public void updateMaxCacheSize(int maxCacheSize)
	{
		this.maxCacheSize = maxCacheSize;
	}
	
	/**
	 * Return the unique instance of the class.
	 */
	public static ActivityReportCache getInstance() 
	{
		return instance;
	}

	/**
	 * A ActivityReportBean object is passed to this method for addition to the cache.
	 */
	public void addActivityReport(ActivityReportBean bean) 
	{
		synchronized(updateLock)
		{ 
			Integer id = bean.getActivityReportId();
			if (null == cache.get(id)) 
			{
	
				// bean not in the cache
				// add bean to the cache, making it the most recently used
				if (0 == currentCacheSize) 
				{
					// treat empty cache as a special case
					lru = mru = new LinkedList();
					mru.bean = bean;
				} 
				else 
				{
					LinkedList newLink;
					if (maxCacheSize < currentCacheSize) 
					{
						// remove the least recently used bean from the cache
						newLink = lru;
						lru = newLink.previous;
						cache.remove(newLink.bean.getActivityReportId());
						lru.next = null;
					} 
					else 
					{
						newLink = new LinkedList();
						currentCacheSize++;
					}
					newLink.bean = bean;
					newLink.next = mru;
					newLink.previous = null;
					mru = newLink;
				}
				// put the now most recently used bean in the cache
				cache.put(id, mru);		
			} 
			else 
			{ 
				// bean already in the cache
				// addBid should not be called when the object is already in the
				// cache however since that happened do a fetch so that the object
				// becomes the most recently used
				fetchActivityReport(id);
			}
		}
	}

	/**
	 * Return the ActivityReportBean associated with the given key.
	 */
	public ActivityReportBean fetchActivityReport(Integer id) 
	{
		LinkedList foundLink = (LinkedList) cache.get(id);
		if (null == foundLink) 
		{
			ActivityReportBean bean = null;
			try 
			{
				bean = ActivityReportManagerImpl.getInstance().loadByPrimaryKey(id);
			} 
			catch (DAOException e) 
			{
				return null;
			}
			if (null != bean) 
			{
				addActivityReport(bean);
			}
			return bean;
		}

		synchronized(updateLock)
		{
			// AFagot [2007-07-06]
			// this could be acheived with the now standard java.util.LinkedList and
			// java.util.ListIterator but the code was already written since 1998 ;-)
			if (mru != foundLink) 
			{
				if (null != foundLink.previous) 
				{
					foundLink.previous.next = foundLink.next;
				}
				if (null != foundLink.next) 
				{
					foundLink.next.previous = foundLink.previous;
				}
				foundLink.previous = null;
				foundLink.next = mru;
				mru = foundLink;
			}
		}

		return foundLink.bean;
	}

	/**
	 * Updates ActivityReportBean object in the cache.
	 */
	public void updateActivityReport(ActivityReportBean bean) 
	{
		synchronized(updateLock)
		{
			// check if the given object is present in the cache
			if (isActivityReportInCache(bean))  
			{
				Integer id = bean.getActivityReportId();			
			
				// if found, update it
				cache.get(id).bean = bean;
			}
			else
			{
				// addActivityReport(bean);
			}
		}
	}

	/**
	 * Removes all entries from the cache
	 */
	public void clearCache()
	{
		synchronized (updateLock)
		{
			cache.clear();
			currentCacheSize = 0;
			lru = mru = new LinkedList();
		}
	}

	/**
	 * Returns true if ActivityReportBean object is in the cache. FALSE otherwise
	 */
	public boolean isActivityReportInCache(ActivityReportBean bean) 
	{
		Integer id = bean.getActivityReportId();

		// check if the given object is present in the cache
		return cache.get(id) == null? false : true;
	}

	/**
	 * Private doubly linked list for managing list of most recently used beans.
	 */
	private class LinkedList 
	{
		ActivityReportBean bean;
		LinkedList previous;
		LinkedList next;
	}
}
