// BlogBridge -- RSS feed reader, manager, and web based service
// Copyright (C) 2002, 2003, 2004 by R. Pito Salas
//
// This program is free software; you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software Foundation;
// either version 2 of the License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
// without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
// See the GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License along with this program;
// if not, write to the Free Software Foundation, Inc., 59 Temple Place,
// Suite 330, Boston, MA 02111-1307 USA
//
// Contact: R. Pito Salas
// mailto:pito_salas@users.sourceforge.net
// More information: about BlogBridge
// http://www.blogbridge.com
// http://sourceforge.net/projects/blogbridge
//
// $Id: UserSearchFeed.java,v 1.4 2007/04/18 13:26:45 alg Exp $
//
package com.salas.bbservice.domain;

/**
 * User's query feed object. Query feeds are simple stored queries, having type,
 * parameter and title. They aren't shared among the users.
 */
public class UserSearchFeed
{
    private static final int HASH_MULTIPLIER = 29;

    private int id          = -1;
    private int userGuideId = -1;
    private int index       = -1;

    private String  title;
    private String  query;
    private int     limit;
    private int     rating;

    private int     viewType = -1;
    private boolean viewModeEnabled = false;
    private int     viewMode = -1;

    private boolean dedupEnabled;
    private int     dedupFrom = -1;
    private int     dedupTo = -1;

    private Boolean ascendingSorting = null;

    /**
     * Creates empty user search feed object.
     */
    public UserSearchFeed()
    {
    }

    /**
     * Creates object with given values.
     *
     * @param aUserGuideId      ID of the user's guide.
     * @param aIndex            index of the feed in list.
     * @param aTitle            title of the feed.
     * @param aQuery            serialized query.
     * @param aLimit            articles (purge) limit.
     * @param aRating           feed rating.
     * @param aViewType         view type.
     * @param aViewModeEnabled  the state of view mode.
     * @param aViewMode         the view mode.
     * @param aAscendingSorting the ascending sorting flag.
     */
    public UserSearchFeed(int aUserGuideId, int aIndex, String aTitle,
        String aQuery, int aLimit, int aRating, int aViewType, boolean aViewModeEnabled, int aViewMode,
        Boolean aAscendingSorting)
    {
        ascendingSorting = aAscendingSorting;
        userGuideId = aUserGuideId;
        index = aIndex;
        title = aTitle;
        query = aQuery;
        limit = aLimit;
        rating = aRating;
        viewType = aViewType;
        viewModeEnabled = aViewModeEnabled;
        viewMode = aViewMode;
    }

    /**
     * Returns remove duplicates flag.
     *
     * @return remove duplicates flag.
     */
    public boolean isDedupEnabled()
    {
        return dedupEnabled;
    }

    /**
     * Sets remove duplicates flag.
     *
     * @param flag remove duplicates flag.
     */
    public void setDedupEnabled(boolean flag)
    {
        dedupEnabled = flag;
    }


    /**
     * Returns the first word to look for duplicates.
     *
     * @return word number.
     */
    public int getDedupFrom()
    {
        return dedupFrom;
    }

    /**
     * Sets the first word to look for duplicates.
     *
     * @param word number
     */
    public void setDedupFrom(int word)
    {
        dedupFrom = word;
    }

    /**
     * Returns the last word to look for duplicates.
     *
     * @return word number.
     */
    public int getDedupTo()
    {
        return dedupTo;
    }

    /**
     * Sets the last word to look for duplicates.
     *
     * @param word number
     */
    public void setDedupTo(int word)
    {
        dedupTo = word;
    }

    /**
     * Returns the identifier.
     *
     * @return identifier.
     */
    public int getId()
    {
        return id;
    }

    /**
     * Sets the identifier.
     *
     * @param id identifier.
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * Returns the ID of the user's guide.
     *
     * @return ID of the guide.
     *
     * @see UserGuide
     */
    public int getUserGuideId()
    {
        return userGuideId;
    }

    /**
     * Sets ID of the user's guide.
     *
     * @param userGuideId ID of the guide.
     *
     * @see UserGuide
     */
    public void setUserGuideId(int userGuideId)
    {
        this.userGuideId = userGuideId;
    }

    /**
     * Returns the index in list of channels within the guide.
     *
     * @return index in list.
     */
    public int getIndex()
    {
        return index;
    }

    /**
     * Sets the index in list of channels within the guide.
     *
     * @param index index in list.
     */
    public void setIndex(int index)
    {
        this.index = index;
    }

    /**
     * Returns title.
     *
     * @return title.
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Sets title.
     *
     * @param aTitle title.
     */
    public void setTitle(String aTitle)
    {
        title = aTitle;
    }

    /**
     * Returns the limit.
     *
     * @return limit.
     */
    public int getLimit()
    {
        return limit;
    }

    /**
     * Sets the limit.
     *
     * @param aLimit limit.
     */
    public void setLimit(int aLimit)
    {
        limit = aLimit;
    }

    /**
     * Returns rating.
     *
     * @return rating.
     */
    public int getRating()
    {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param aRating rating.
     */
    public void setRating(int aRating)
    {
        rating = aRating;
    }

    /**
     * Returns query.
     *
     * @return query.
     */
    public String getQuery()
    {
        return query;
    }

    /**
     * Sets query.
     *
     * @param aQuery query.
     */
    public void setQuery(String aQuery)
    {
        query = aQuery;
    }

    /**
     * Returns view type.
     *
     * @return type.
     */
    public int getViewType()
    {
        return viewType;
    }

    /**
     * Sets view type.
     *
     * @param aViewType view type.
     */
    public void setViewType(int aViewType)
    {
        viewType = aViewType;
    }

    /**
     * Returns the state of view mode enabled flag.
     *
     * @return <code>TRUE</code> when custom view mode is enabled.
     */
    public boolean isViewModeEnabled()
    {
        return viewModeEnabled;
    }

    /**
     * Sets the state of view mode enabled flag.
     *
     * @param en <code>TRUE</code> to enable custom view mode.
     */
    public void setViewModeEnabled(boolean en)
    {
        this.viewModeEnabled = en;
    }

    /**
     * Returns custom view mode.
     *
     * @return custom view mode.
     */
    public int getViewMode()
    {
        return viewMode;
    }

    /**
     * Sets custom view mode.
     *
     * @param mode custom view mode.
     */
    public void setViewMode(int mode)
    {
        this.viewMode = mode;
    }

    /**
     * Returns the ascending sorting state.
     *
     * @return ascending sorting.
     */
    public Boolean getAscendingSorting()
    {
        return ascendingSorting;
    }

    /**
     * Sets the ascending sorting state.
     *
     * @param asc state.
     */
    public void setAscendingSorting(Boolean asc)
    {
        this.ascendingSorting = asc;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare.
     *
     * @return  <code>true</code> if this object is the same as the obj
     *          argument; <code>false</code> otherwise.
     */
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final UserSearchFeed feed = (UserSearchFeed)o;

        if (index != feed.index) return false;
        if (userGuideId != feed.userGuideId) return false;
        if (!query.equals(feed.query)) return false;
        if (!title.equals(feed.title)) return false;
        if (limit != feed.limit) return false;
        if (rating != feed.rating) return false;

        if (viewMode != feed.viewMode) return false;
        if (viewModeEnabled != feed.viewModeEnabled) return false;

        if (dedupEnabled != feed.dedupEnabled) return false;
        if (dedupFrom != feed.dedupFrom) return false;
        if (dedupTo != feed.dedupTo) return false;

        if (ascendingSorting != null
            ? !ascendingSorting.equals(feed.ascendingSorting)
            : feed.ascendingSorting != null) return false;

        return viewType == feed.viewType;
    }

    /**
     * Returns a hash code value for the object. This method is
     * supported for the benefit of hashtables such as those provided by
     * <code>java.util.Hashtable</code>.
     *
     * @return  a hash code value for this object.
     */
    public int hashCode()
    {
        int result;
        result = userGuideId;
        result = HASH_MULTIPLIER * result + index;
        result = HASH_MULTIPLIER * result + title.hashCode();
        return result;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    public String toString()
    {
        return "UserSearchFeed: id=" + id +
            ", userGuideId=" + userGuideId +
            ", index=" + index +
            ", title=" + title +
            ", query=" + query +
            ", limit=" + limit +
            ", rating=" + rating +
            ", viewType=" + viewType +
            ", viewModeEnabled=" + viewModeEnabled +
            ", viewMode=" + viewMode +
            ", dedupEnabled=" + dedupEnabled +
            ", dedupFrom=" + dedupFrom +
            ", dedupTo=" + dedupTo +
            ", ascendingSorting=" + ascendingSorting;
    }
}
