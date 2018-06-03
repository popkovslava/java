package org.project.dao;

import org.project.dao.Interface.PostsDao;
import org.project.entity.Posts;
import org.springframework.stereotype.Repository;

@Repository
public class PostDaoImpl extends BaseDaoImpl<Long, Posts> implements PostsDao {
}
