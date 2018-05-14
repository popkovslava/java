package org.progect.service;

import org.project.dao.PostsDao;
import org.project.entity.PostsEntity;

import java.util.List;

public class ProjectService {

    private static final ProjectService INSTANCE = new ProjectService();

    public List<PostsEntity> getPost() {
        return PostsDao.getInstance().getAll();
    }

    public void setPost() {
         PostsEntity postsEntity=new PostsEntity();
         postsEntity.setTitle("Test");
         postsEntity.setText("Test Text");
         PostsDao.getInstance().save(postsEntity);
    }

    public static ProjectService getInstance() {
        return INSTANCE;
    }
}
