




// ______________________________________________________
// Generated by sql2java - http://sql2java.sourceforge.net/
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
//
// Author: Javed Kansi
// ______________________________________________________

package uk.co.planetbeyond.generated.comparator;

import java.util.Comparator;
import uk.co.planetbeyond.generated.ActivityBean;
import uk.co.planetbeyond.generated.ActivityManager;


/**
 * Comparator class is used to sort the ActivityBean objects.
 * @author sql2java
 */
public class ActivityComparator implements Comparator
{
    /**
     * Holds the field on which the comparison is performed.
     */
    private int iType;
    /**
     * Value that will contain the information about the order of the sort: normal or reversal.
     */
    private boolean bReverse;

    /**
     * Constructor class for ActivityComparator.
     * <br>
     * Example:
     * <br>
     * <code>Arrays.sort(pArray, new ActivityComparator(ActivityManager.ID_DTMF, bReverse));<code>
     *
     * @param iType the field from which you want to sort
     * <br>
     * Possible values are:
     * <ul>
     *   <li>ActivityManager.ID_DTMF
     *   <li>ActivityManager.ID_DURATION
     *   <li>ActivityManager.ID_ACTIVITY_NAME
     *   <li>ActivityManager.ID_CONTEXT
     *   <li>ActivityManager.ID_CREATION_TIMESTAMP
     *   <li>ActivityManager.ID_UNIQUE_ID
     *   <li>ActivityManager.ID_MSISDN
     *   <li>ActivityManager.ID_ACTIVITY_ID
     * </ul>
     */
    public ActivityComparator(int iType)
    {
        this(iType, false);
    }

    /**
     * Constructor class for ActivityComparator.
     * <br>
     * Example:
     * <br>
     * <code>Arrays.sort(pArray, new ActivityComparator(ActivityManager.ID_DTMF, bReverse));<code>
     *
     * @param iType the field from which you want to sort.
     * <br>
     * Possible values are:
     * <ul>
     *   <li>ActivityManager.ID_DTMF
     *   <li>ActivityManager.ID_DURATION
     *   <li>ActivityManager.ID_ACTIVITY_NAME
     *   <li>ActivityManager.ID_CONTEXT
     *   <li>ActivityManager.ID_CREATION_TIMESTAMP
     *   <li>ActivityManager.ID_UNIQUE_ID
     *   <li>ActivityManager.ID_MSISDN
     *   <li>ActivityManager.ID_ACTIVITY_ID
     * </ul>
     *
     * @param bReverse set this value to true, if you want to reverse the sorting results
     */
    public ActivityComparator(int iType, boolean bReverse)
    {
        this.iType = iType;
        this.bReverse = bReverse;
    }

    /**
     * Implementation of the compare method.
     */
    public int compare(Object pObj1, Object pObj2)
    {
        ActivityBean b1 = (ActivityBean)pObj1;
        ActivityBean b2 = (ActivityBean)pObj2;
        int iReturn = 0;
        switch(iType)
        {
            case ActivityManager.ID_DTMF:
                if (b1.getDtmf() == null && b2.getDtmf() != null) {
                    iReturn = -1;
                } else if (b1.getDtmf() == null && b2.getDtmf() == null) {
                    iReturn = 0;
                } else if (b1.getDtmf() != null && b2.getDtmf() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getDtmf().compareTo(b2.getDtmf());
                }
                break;
            case ActivityManager.ID_DURATION:
                if (b1.getDuration() == null && b2.getDuration() != null) {
                    iReturn = -1;
                } else if (b1.getDuration() == null && b2.getDuration() == null) {
                    iReturn = 0;
                } else if (b1.getDuration() != null && b2.getDuration() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getDuration().compareTo(b2.getDuration());
                }
                break;
            case ActivityManager.ID_ACTIVITY_NAME:
                if (b1.getActivityName() == null && b2.getActivityName() != null) {
                    iReturn = -1;
                } else if (b1.getActivityName() == null && b2.getActivityName() == null) {
                    iReturn = 0;
                } else if (b1.getActivityName() != null && b2.getActivityName() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getActivityName().compareTo(b2.getActivityName());
                }
                break;
            case ActivityManager.ID_CONTEXT:
                if (b1.getContext() == null && b2.getContext() != null) {
                    iReturn = -1;
                } else if (b1.getContext() == null && b2.getContext() == null) {
                    iReturn = 0;
                } else if (b1.getContext() != null && b2.getContext() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getContext().compareTo(b2.getContext());
                }
                break;
            case ActivityManager.ID_CREATION_TIMESTAMP:
                if (b1.getCreationTimestamp() == null && b2.getCreationTimestamp() != null) {
                    iReturn = -1;
                } else if (b1.getCreationTimestamp() == null && b2.getCreationTimestamp() == null) {
                    iReturn = 0;
                } else if (b1.getCreationTimestamp() != null && b2.getCreationTimestamp() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getCreationTimestamp().compareTo(b2.getCreationTimestamp());
                }
                break;
            case ActivityManager.ID_UNIQUE_ID:
                if (b1.getUniqueId() == null && b2.getUniqueId() != null) {
                    iReturn = -1;
                } else if (b1.getUniqueId() == null && b2.getUniqueId() == null) {
                    iReturn = 0;
                } else if (b1.getUniqueId() != null && b2.getUniqueId() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getUniqueId().compareTo(b2.getUniqueId());
                }
                break;
            case ActivityManager.ID_MSISDN:
                if (b1.getMsisdn() == null && b2.getMsisdn() != null) {
                    iReturn = -1;
                } else if (b1.getMsisdn() == null && b2.getMsisdn() == null) {
                    iReturn = 0;
                } else if (b1.getMsisdn() != null && b2.getMsisdn() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getMsisdn().compareTo(b2.getMsisdn());
                }
                break;
            case ActivityManager.ID_ACTIVITY_ID:
                if (b1.getActivityId() == null && b2.getActivityId() != null) {
                    iReturn = -1;
                } else if (b1.getActivityId() == null && b2.getActivityId() == null) {
                    iReturn = 0;
                } else if (b1.getActivityId() != null && b2.getActivityId() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getActivityId().compareTo(b2.getActivityId());
                }
                break;
            default:
                throw new IllegalArgumentException("Type passed for the field is not supported");
        }

        return bReverse ? (-1 * iReturn) : iReturn;
    }}
