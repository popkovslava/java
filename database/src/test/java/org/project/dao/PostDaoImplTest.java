package org.project.dao;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.dao.Interface.PostsDao;
import org.project.entity.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:application-context.xml")
@Transactional
public class PostDaoImplTest {

    @Autowired
    private PostsDao postsDao;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", postsDao);
    }

    @Test
    public void checkSaveEntity() {
        Posts posts = new Posts();
        posts.setTitle("test");
        Long id = postsDao.save(posts);
        assertNotNull("Entity is not saved", id);
    }

    @Test
    public void checkFindAll() {
        List<Posts> posts = postsDao.findAll();
        assertThat("Employees collection is not empty", posts, hasSize(0));
    }

    @Test
    public void checkFindEntityById() {
        Posts posts = new Posts();
        posts.setTitle("test");
        Long id = postsDao.save(posts);
        Posts menu1 = postsDao.findOne(id);
        assertNotNull("FindById does not work", menu1);
    }

}