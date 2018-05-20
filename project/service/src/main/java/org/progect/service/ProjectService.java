package org.progect.service;

import org.project.dao.PostsDao;
import org.project.entity.Posts;

import java.util.List;

public class ProjectService {

    private static final ProjectService INSTANCE = new ProjectService();

    public List<Posts> getPost() {
        return PostsDao.getInstance().getAll();
    }

    public void setPost() {
         Posts postsEntity=new Posts();
         postsEntity.setTitle("Test");
         postsEntity.setText("Test Text");
         PostsDao.getInstance().save(postsEntity);
    }

    public static ProjectService getInstance() {
        return INSTANCE;
    }
}
