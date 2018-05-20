package org.project.dao;

import org.project.dao.Interface.PagesDaoInterface;
import org.project.entity.Pages;


public class PostDao   extends BaseDao<Long, Pages> implements PagesDaoInterface{
    private static final PostDao INSTANCE = new PostDao();
    public static PostDao getInstance() {
        return INSTANCE;
    }
}
