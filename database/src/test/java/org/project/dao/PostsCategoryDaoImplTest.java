package org.project.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.project.entity.Pages;
import org.project.entity.PostsCategory;
import org.project.manager.SessionFactoryManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertNotEquals;

public class PostsCategoryDaoImplTest {
    private static final SessionFactory SESSION_FACTORY = SessionFactoryManager.getSessionFactory();


    @AfterClass
    public static void after() {
        SESSION_FACTORY.close();
    }

    @Before
    public void cleanEntity() {
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from PostsCategory");
            session.getTransaction().commit();
        }
    }

    @Test(priority = 1)
    public void checkSaveEntity() {
        Pages p = new Pages();
        p.setTitle("Test");
        PagesDaoImpl.getInstance().save(p);
        PostsCategory pc = new PostsCategory();
        pc.setPages(p);
        pc.setTitle("Title");
        pc.setText("Text");
        Serializable lis = PostsCategoryDaoImpl.getInstance().save(pc);
        assertNotNull("Id is null", lis);
    }

    @Test(priority = 2)
    public void checkFindById() {
        List<PostsCategory> list = PostsCategoryDaoImpl.getInstance().findAll();
        for (PostsCategory li : list) {
            assertNotNull("Id is null", PostsCategoryDaoImpl.getInstance().findById(li.getId()));
        }
    }

    @Test(priority = 3)
    public void findAll() {
        List<PostsCategory> list = PostsCategoryDaoImpl.getInstance().findAll();
        assertNotNull("Id is null", list);
    }

    @Test(priority = 4)
    public void update() {
        List<PostsCategory> list = PostsCategoryDaoImpl.getInstance().findAll();
        for (PostsCategory li : list) {
            String old = li.getTitle();
            li.setId(li.getId());
            li.setTitle("Upadte");
            li.setText("Upadte");
            PostsCategoryDaoImpl.getInstance().update(li);
            PostsCategory news = PostsCategoryDaoImpl.getInstance().findById(li.getId());
            assertNotEquals(old, news.getTitle());
            assertNotNull("Id is null", news);
        }
    }

    @Test(priority = 5)
    public void delete() {
        List<PostsCategory> list = PostsCategoryDaoImpl.getInstance().findAll();
        for (PostsCategory li : list) {
            PostsCategoryDaoImpl.getInstance()
                    .delete(PostsCategoryDaoImpl.getInstance()
                            .findById(li.getId()));
        }
        assertTrue(!list.isEmpty());
    }

}