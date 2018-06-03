package org.project.dao;

import org.project.dao.Interface.PostsCategoryDao;
import org.project.entity.PostsCategory;
import org.springframework.stereotype.Repository;

@Repository
public class PostsCategoryDaoImpl extends BaseDaoImpl<Long, PostsCategory> implements PostsCategoryDao {
}
