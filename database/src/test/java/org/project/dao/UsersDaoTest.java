package org.project.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.project.entity.UserAddress;
import org.project.entity.UserData;
import org.project.entity.Users;
import org.project.manager.SessionFactoryManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertNotEquals;

public class UsersDaoTest {

    private static final SessionFactory SESSION_FACTORY = SessionFactoryManager.getSessionFactory();

    @AfterClass
    public static void after() {
        SESSION_FACTORY.close();
    }

    @Before
    public void cleanEntity() {
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Users");
            session.getTransaction().commit();
        }
    }

    @Test(priority = 1)
    public void checkSaveEntity() {
        Users list = new Users();
        list.setName("Save");
        list.getId();
        Serializable lis = UsersDaoImpl.getInstance().save(list);
        UserData userData = new UserData();
        userData.setMobile("Save");
        userData.setEmail("Save@mail.ru");
        userData.setUserAdress(UserAddress.COUNTRY);
        userData.setUser(list);
        UsersDataDaoImpl.getInstance().save(userData);
        assertNotNull("Id is null", lis);
    }

    @Test(priority = 2)
    public void checkFindById() {
        List<Users> list = UsersDaoImpl.getInstance().findAll();
        for (Users li : list) {
            Users u = UsersDaoImpl.getInstance().findById(li.getId());
            assertNotNull("Id is null", u);
        }
    }

    @Test(priority = 3)
    public void findAll() {
        List<Users> list = UsersDaoImpl.getInstance().findAll();
        assertNotNull("Id is null", list);
    }

    @Test(priority = 4)
    public void update() {
        List<Users> list = UsersDaoImpl.getInstance().findAll();
        for (Users li : list) {
            String old = li.getName();
            li.setId(li.getId());
            li.setName("Update");
            UsersDaoImpl.getInstance().update(li);
            Users news = UsersDaoImpl.getInstance().findById(li.getId());
            UserData userData = new UserData();
            userData.setId(li.getId());
            userData.setUser(li);
            userData.setMobile("Update");
            userData.setEmail("upadte@mail.ru");
            userData.setUserAdress(UserAddress.COUNTRY);
            UsersDataDaoImpl.getInstance().update(userData);
            assertNotEquals(old, news.getName());
            assertNotNull("Id is null", news.getName());
        }
    }

    @Test(priority = 5)
    public void delete() {
        List<Users> list = UsersDaoImpl.getInstance().findAll();
        for (Users li : list) {
            UserData userData = new UserData();
            userData.setId(li.getId());
            UsersDataDaoImpl.getInstance().delete(userData);
            UsersDaoImpl.getInstance().delete(UsersDaoImpl.getInstance().findById(li.getId()));
        }
        assertTrue("Delete  is null", !list.isEmpty());
    }

}