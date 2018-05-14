package org.project.dao;


import org.project.entity.PostCtegoryEntity;

import java.util.List;


public class PostCategoryDao extends BaseDao{

    private static final PostCategoryDao INSTANCE = new PostCategoryDao();

    public void save(PostCtegoryEntity postCtegory) {
        saveBase(postCtegory);
    }

    public void update(PostCtegoryEntity postCtegory) {
        updateBase(postCtegory);
    }

    public PostCtegoryEntity getById(Long id) {
        return getByIdBase(new PostCtegoryEntity(), id);
    }

    public void removeById(Long id) {
        removeByIdBase(new PostCtegoryEntity(), id);
    }

    public List<PostCtegoryEntity> getAll() {
        return getAllBase(new PostCtegoryEntity());
    }

    public static PostCategoryDao getInstance() {
        return INSTANCE;
    }
}
