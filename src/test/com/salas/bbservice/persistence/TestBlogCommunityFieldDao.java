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
// $Id: TestBlogCommunityFieldDao.java,v 1.1.1.1 2006/10/23 13:55:53 alg Exp $
//

package com.salas.bbservice.persistence;

import com.salas.bbservice.domain.BlogCommunityField;
import com.salas.bbservice.domain.Blog;

/**
 * @see IBlogCommunityFieldDao
 */
public class TestBlogCommunityFieldDao extends BasicDaoTestCase
{
    /**
     * Tests construction of an object.
     */
    public void testCreate()
    {
        BlogCommunityField fld = new BlogCommunityField(1, "name", "value");
        assertEquals(1, fld.getBlogId());
        assertEquals("name", fld.getName());
        assertEquals("value", fld.getValue());
    }

    /**
     * Assignment of single-value field.
     */
    public void testSetGetSingleValue()
    {
        Blog blog;

        blog = new Blog("A", "B", "C", "D", "E", 1, null, null, Blog.STATUS_INVALID, 1);
        blogDao.add(blog);

        try
        {
            blogCommunityFieldDao.set(blog.getId(), "test", "test");

            BlogCommunityField[] flds = blogCommunityFieldDao.get(blog.getId());
            assertNotNull(flds);
            assertEquals(1, flds.length);
            assertEquals(new BlogCommunityField(blog.getId(), "test", "test"), flds[0]);
        } finally
        {
            if (blog.getId() > -1) blogDao.delete(blog);
        }
    }

    /**
     * Assignment of multi-value field.
     */
    public void testSetGetMultiValue()
    {
        Blog blog;

        blog = new Blog("A", "B", "C", "D", "E", 1, null, null, Blog.STATUS_INVALID, 1);
        blogDao.add(blog);

        try
        {
            blogCommunityFieldDao.set(blog.getId(), "test", new String[] { "a", "b", "c" });

            BlogCommunityField[] flds = blogCommunityFieldDao.get(blog.getId());
            assertNotNull(flds);
            assertEquals(3, flds.length);
            assertEquals(new BlogCommunityField(blog.getId(), "test", "a"), flds[0]);
            assertEquals(new BlogCommunityField(blog.getId(), "test", "b"), flds[1]);
            assertEquals(new BlogCommunityField(blog.getId(), "test", "c"), flds[2]);
        } finally
        {
            if (blog.getId() > -1) blogDao.delete(blog);
        }
    }

    /**
     * Assignment of multi-value field with duplicates.
     */
    public void testSetGetMultiValueWithDuplicates()
    {
        Blog blog;

        blog = new Blog("A", "B", "C", "D", "E", 1, null, null, Blog.STATUS_INVALID, 1);
        blogDao.add(blog);

        try
        {
            blogCommunityFieldDao.set(blog.getId(), "test", new String[] { "a", "b", "a" });

            BlogCommunityField[] flds = blogCommunityFieldDao.get(blog.getId());
            assertNotNull(flds);
            assertEquals(2, flds.length);
            assertEquals(new BlogCommunityField(blog.getId(), "test", "a"), flds[0]);
            assertEquals(new BlogCommunityField(blog.getId(), "test", "b"), flds[1]);
        } finally
        {
            if (blog.getId() > -1) blogDao.delete(blog);
        }
    }
}
