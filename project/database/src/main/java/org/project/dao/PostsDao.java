package org.project.dao;

import org.project.entity.Posts;

import java.util.List;

public class PostsDao extends BaseDao {

    private static final PostsDao INSTANCE = new PostsDao();

    public void save(Posts posts) {
        saveBase(posts);
    }

    public void update(Posts posts) {
        updateBase(posts);
    }

    public Posts getById(Long id) {
        return getByIdBase(new Posts(), id);
    }

    public void removeById(Long id) {
        removeByIdBase(new Posts(), id);
    }

    public List<Posts> getAll() {
        return getAllBase(new Posts());
    }

    public static PostsDao getInstance() {
        return INSTANCE;
    }
}
