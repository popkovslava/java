package org.project.dao;


import org.project.entity.PostsEntity;

import java.util.List;

public class PostsDao extends BaseDao {

    private static final PostsDao INSTANCE = new PostsDao();

    public void save(PostsEntity posts) {
        saveBase(posts);
    }

    public void update(PostsEntity posts) {
        updateBase(posts);
    }

    public PostsEntity getById(Long id) {
        return getByIdBase(new PostsEntity(), id);
    }

    public void removeById(Long id) {
        removeByIdBase(new PostsEntity(), id);
    }

    public List<PostsEntity> getAll() {
        return getAllBase(new PostsEntity());
    }

    public static PostsDao getInstance() {
        return INSTANCE;
    }
}
