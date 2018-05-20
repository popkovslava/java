package org.project.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.project.entity.Menu;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


public class MenuDaoTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Menu ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        Menu menu =new Menu();
        menu.setTitle("SLON CLASS");
        Serializable serializable=MenuDao.getInstance().save(menu);
        assertNotNull("Id is null", serializable);
    }

    @Test
    public void checkFindById() {
        Menu menu =new Menu();
        menu.setTitle("Check Find By");
        MenuDao.getInstance().save(menu);
        Menu obj= MenuDao.getInstance().findById(1L);
        assertNotNull("Id is null", obj);
    }

    @Test
    public void findAll() {
        List<Menu> menus=MenuDao.getInstance().findAll();
        assertNotNull("Id is null", menus);
    }

    @Test
    public void update() {
        Menu menu =new Menu();
        menu.setId(1l);
        menu.setTitle("Check Update");
        MenuDao.getInstance().update(menu);
    }

    @Test
    public void delete() {
        Menu menu =new Menu();
        menu.setTitle("SLON CLASS");
        MenuDao.getInstance().save(menu);
        MenuDao.getInstance().delete(MenuDao.getInstance().findById(1L));
        assertNull("Id is not null", MenuDao.getInstance().findById(1L));
    }

}