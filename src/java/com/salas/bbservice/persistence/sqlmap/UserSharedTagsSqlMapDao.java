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
// $Id: UserSharedTagsSqlMapDao.java,v 1.1.1.1 2006/10/23 13:55:40 alg Exp $
//
package com.salas.bbservice.persistence.sqlmap;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.salas.bbservice.domain.UserPreference;
import com.salas.bbservice.domain.UserSharedTags;
import com.salas.bbservice.domain.dao.SharedTagsQueryParam;
import com.salas.bbservice.persistence.IUserPreferenceDao;
import com.salas.bbservice.persistence.IUserSharedTagsDao;
import com.salas.bbservice.utils.StringUtils;

import java.util.List;

/**
 * SqlMap implementation for User Shared Tags DAO.
 */
public class UserSharedTagsSqlMapDao extends SqlMapDaoTemplate implements IUserSharedTagsDao
{
    /**
     * Creates DAO.
     *
     * @param daoManager manager.
     */
    public UserSharedTagsSqlMapDao(DaoManager daoManager)
    {
        super(daoManager);
    }

    /**
     * Tags some link. If tags are empty the record will be removed from user's tags list.
     *
     * @param tags link and tags details.
     */
    public void tagLink(UserSharedTags tags)
    {
        delete("UserSharedTags.delete", tags);

        String tagsList = tags.getTags();
        if (!StringUtils.isEmpty(tagsList)) insert("UserSharedTags.insert", tags);
    }

    /**
     * Returns the list of tags (multi-tag strings) for a given link except for user with given ID.
     *
     * @param url             link.
     * @param exceptionUserId ID to skip when reading tags.
     *
     * @return list of strings-tags.
     */
    public List getLinkTags(String url, long exceptionUserId)
    {
        return queryForList("UserSharedTags.getLinkTags",
            new SharedTagsQueryParam(url, exceptionUserId));
    }
}
