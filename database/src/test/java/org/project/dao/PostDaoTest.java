package org.project.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.project.entity.Posts;
import org.project.manager.SessionFactoryManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertNotEquals;


public class PostDaoTest {

    private static final SessionFactory SESSION_FACTORY = SessionFactoryManager.getSessionFactory();

    @AfterClass
    public static void after() {
        SESSION_FACTORY.close();
    }

    @Before
    public void cleanEntity() {
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Posts ");
            session.getTransaction().commit();
        }
    }

    @Test(priority = 1)
    public void checkSaveEntity() {
        Posts list = new Posts();
        list.setTitle("Check Title");
        Serializable lis = PostDaoImpl.getInstance().save(list);
        assertNotNull("Id is null", lis);
    }

    @Test(priority = 2)
    public void checkFindById() {
        List<Posts> list = PostDaoImpl.getInstance().findAll();
        for (Posts li : list) {
            Posts ln = PostDaoImpl.getInstance().findById(li.getId());
            assertNotNull("Id is null", ln);
        }
    }

    @Test(priority = 3)
    public void findAll() {
        List<Posts> list = PostDaoImpl.getInstance().findAll();
        assertNotNull("Id is null", list);
    }

    @Test(priority = 4)
    public void update() {
        List<Posts> list = PostDaoImpl.getInstance().findAll();
        for (Posts li : list) {
            String old = li.getTitle();
            li.setId(li.getId());
            li.setTitle("Check Update");
            PostDaoImpl.getInstance().update(li);
            Posts news = PostDaoImpl.getInstance().findById(li.getId());
            assertNotEquals(old, news.getTitle());
            assertNotNull("Id is null", news);
        }
    }

    @Test(priority = 5)
    public void delete() {
        List<Posts> list = PostDaoImpl.getInstance().findAll();
        for (Posts li : list) {
            PostDaoImpl.getInstance().delete(PostDaoImpl.getInstance().findById(li.getId()));
        }
        assertTrue(!list.isEmpty());
    }
}