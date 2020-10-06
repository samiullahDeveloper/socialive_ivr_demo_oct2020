




// ______________________________________________________
// Generated by sql2java - http://sql2java.sourceforge.net/
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
//
// Author: Javed Kansi
// ______________________________________________________

package uk.co.planetbeyond.generated;

import java.io.Serializable;
import com.sleepycat.persist.model.Persistent;
import org.apache.commons.lang.builder.EqualsBuilder;

import uk.co.planetbeyond.manager.CategoryManagerImpl;

/**
 * CategoryBean is a mapping of category Table.
 * @author sql2java
*/
@Persistent
public class BaseCategoryBean extends BaseGeneratedBean implements Serializable
{
	private static final long serialVersionUID = -22141528167004907L;
	
    protected Integer menuNumber;
    protected String contentFolder;
    protected String description;
    protected String categoryName;
    protected Integer categoryId;

    /**
     * Prefered methods to create a CategoryBean is via the createCategoryBean method in CategoryManager or
     * via the factory class CategoryFactory create method
     */
    public BaseCategoryBean()
    {
    }

    /**
     * Getter method for menuNumber.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: category.menu_number</li>
     * <li>column size: 3</li>
     * <li>jdbc type returned by the driver: Types.TINYINT</li>
     * </ul>
     *
     * @return the value of menuNumber
     */
    public Integer getMenuNumber()
    {
        return menuNumber;
    }

    /**
     * Setter method for menuNumber.
     * <br>
     *
     * @param newVal the new value to be assigned to menuNumber
     */
    public void setMenuNumber(Integer newVal)
    {
        menuNumber = newVal;
    }

    /**
     * Getter method for contentFolder.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: category.content_folder</li>
     * <li>column size: 100</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of contentFolder
     */
    public String getContentFolder()
    {
        return contentFolder;
    }

    /**
     * Setter method for contentFolder.
     * <br>
     *
     * @param newVal the new value to be assigned to contentFolder
     */
    public void setContentFolder(String newVal)
    {
        contentFolder = newVal;
    }

    /**
     * Getter method for description.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: category.description</li>
     * <li>column size: 200</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Setter method for description.
     * <br>
     *
     * @param newVal the new value to be assigned to description
     */
    public void setDescription(String newVal)
    {
        description = newVal;
    }

    /**
     * Getter method for categoryName.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: category.category_name</li>
     * <li>column size: 100</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of categoryName
     */
    public String getCategoryName()
    {
        return categoryName;
    }

    /**
     * Setter method for categoryName.
     * <br>
     *
     * @param newVal the new value to be assigned to categoryName
     */
    public void setCategoryName(String newVal)
    {
        categoryName = newVal;
    }

    /**
     * Getter method for categoryId.
     * <br>
     * PRIMARY KEY.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: category.category_id</li>
     * <li> imported key: content.category_id</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of categoryId
     */
    public Integer getCategoryId()
    {
        return categoryId;
    }

    /**
     * Setter method for categoryId.
     * <br>
     *
     * @param newVal the new value to be assigned to categoryId
     */
    public void setCategoryId(Integer newVal)
    {
        categoryId = newVal;
    }


    /**
     * Copies the passed bean into the current bean.
     *
     * @param bean the bean to copy into the current bean
     */
    public void copy(BaseCategoryBean bean)
    {
        setMenuNumber(bean.getMenuNumber());
        setContentFolder(bean.getContentFolder());
        setDescription(bean.getDescription());
        setCategoryName(bean.getCategoryName());
        setCategoryId(bean.getCategoryId());
    }

    /**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object)
	{
		if (!(object instanceof BaseCategoryBean)) {
			return false;
		}

		BaseCategoryBean obj = (BaseCategoryBean) object;
		return new EqualsBuilder()
            .append(getMenuNumber(), obj.getMenuNumber())
            .append(getContentFolder(), obj.getContentFolder())
            .append(getDescription(), obj.getDescription())
            .append(getCategoryName(), obj.getCategoryName())
            .append(getCategoryId(), obj.getCategoryId())
            .isEquals();
	}


    /**
     * Converts the current object to full form of the bean which includes all utility methods as well
     */
    public CategoryBean toManagedBean()
    {
	CategoryBean bean = CategoryManagerImpl.getInstance().createCategoryBean();
        bean.setMenuNumber(getMenuNumber());
        bean.setContentFolder(getContentFolder());
        bean.setDescription(getDescription());
        bean.setCategoryName(getCategoryName());
        bean.setCategoryId(getCategoryId());
	return bean;
    }
}
