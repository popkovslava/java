package org.project.dao;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.dao.Interface.PostsCategoryDao;
import org.project.entity.PostsCategory;
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
public class PostsCategoryDaoImplTest {

    @Autowired
    private PostsCategoryDao postsCategoryDao;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", postsCategoryDao);
    }

    @Test
    public void checkSaveEntity() {
        PostsCategory postsCategory = new PostsCategory();
        postsCategory.setTitle("test");
        Long id = postsCategoryDao.save(postsCategory);
        assertNotNull("Entity is not saved", id);
    }

    @Test
    public void checkFindAll() {
        List<PostsCategory> posts = postsCategoryDao.findAll();
        assertThat("Employees collection is not empty", posts, hasSize(0));
    }

    @Test
    public void checkFindEntityById() {
        PostsCategory posts = new PostsCategory();
        posts.setTitle("test");
        Long id = postsCategoryDao.save(posts);
        PostsCategory menu1 = postsCategoryDao.findOne(id);
        assertNotNull("FindById does not work", menu1);
    }

}