package org.project.dao;

import org.project.entity.PostCtegory;

import java.util.List;

public class PostCategoryDao extends BaseDao {

    private static final PostCategoryDao INSTANCE = new PostCategoryDao();

    public void save(PostCtegory postCtegory) {
        saveBase(postCtegory);
    }

    public void update(PostCtegory postCtegory) {
        updateBase(postCtegory);
    }

    public PostCtegory getById(Long id) {
        return getByIdBase(new PostCtegory(), id);
    }

    public void removeById(Long id) {
        removeByIdBase(new PostCtegory(), id);
    }

    public List<PostCtegory> getAll() {
        return getAllBase(new PostCtegory());
    }

    public static PostCategoryDao getInstance() {
        return INSTANCE;
    }
}
