package org.progect.service;

public class ProjectService {

    private static final ProjectService INSTANCE = new ProjectService();

//    public List<Posts> getPost() {
//        return Pages.getInstance().getAll();
//    }

//    public void setPost() {
//         Posts postsEntity=new Posts();
//         postsEntity.setTitle("Test");
//         postsEntity.setText("Test Text");
//         PostsDao.getInstance().save(postsEntity);
//    }

    public static ProjectService getInstance() {
        return INSTANCE;
    }
}
