




// ______________________________________________________
// Generated by sql2java - http://sql2java.sourceforge.net/
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
//
// Author: Javed Kansi
// ______________________________________________________

package uk.co.planetbeyond.manager;

import uk.co.planetbeyond.generated.CategoryManager;
import uk.co.planetbeyond.generated.CategoryBean;
import uk.co.planetbeyond.managedbean.CategoryManagedBean;

/**
* If any change needs to be made to the CategoryManager, it MUST not be made directly
* Instead the CategoryManagerImpl class should be used to make the changes
*/
public class CategoryManagerImpl extends CategoryManager 
{
	/**
	* Singleton instance of this class
	*/
	private static CategoryManagerImpl singleton = new CategoryManagerImpl();
	
	/**
	* Make the constructor private to make the class singleton
	*/
	private CategoryManagerImpl()
	{
		super();
		
		// set the singleton instance of CategoryManagerImpl class in the CategoryManager so that
		// CategoryManager.getInstance() also points to the singleton instance of CategoryManagerImpl 
		setInstance(this);
	}
	
	/**
	* To make the singleton instance available to external classes
	*/
	public static CategoryManagerImpl getInstance()
	{
		return singleton;
	}

	/**
	* Override this method so that it returns an instance of CategoryManagedBean instead of CategoryBean
	*/
	@Override
	public CategoryBean createCategoryBean()
	{
		return new CategoryManagedBean();
	}   
}
