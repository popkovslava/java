package org.project.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.project.dao.Interface.PostsDao;
import org.project.entity.Posts;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostDaoImpl extends BaseDao<Long, Posts> implements PostsDao {

    private static final PostDaoImpl INSTANCE = new PostDaoImpl();

    public static PostDaoImpl getInstance() {
        return INSTANCE;
    }
}
