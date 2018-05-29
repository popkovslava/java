package org.project.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.project.dao.Interface.PostsCategoryDao;
import org.project.entity.PostsCategory;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostsCategoryDaoImpl extends BaseDao<Long, PostsCategory> implements PostsCategoryDao {

    private static final PostsCategoryDaoImpl INSTANCE = new PostsCategoryDaoImpl();

    public static PostsCategoryDaoImpl getInstance() {
        return INSTANCE;
    }
}
