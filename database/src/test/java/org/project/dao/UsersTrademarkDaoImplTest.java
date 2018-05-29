package org.project.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.project.entity.Trademark;
import org.project.entity.UserTrademark;
import org.project.entity.Users;
import org.project.manager.SessionFactoryManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UsersTrademarkDaoImplTest {

    private static final SessionFactory SESSION_FACTORY = SessionFactoryManager.getSessionFactory();

    @AfterClass
    public static void after() {
        SESSION_FACTORY.close();
    }

    @Before
    public void cleanEntity() {
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from UserTrademark");
            session.getTransaction().commit();
        }
    }

    @Test(priority = 1)
    public void checkSaveEntity() {
        Users list = new Users();
        list.setName("Save");
        UsersDaoImpl.getInstance().save(list);
        Trademark trademark = new Trademark();
        trademark.setArticle("Save");
        trademark.setTitle("Save");
        TrademarkDaoImpl.getInstance().save(trademark);
        UserTrademark usersTrademark = new UserTrademark();
        usersTrademark.setUsers(list);
        usersTrademark.setTrademark(trademark);
        Serializable lis = UsersTrademarkDaoImpl.getInstance().save(usersTrademark);
        assertNotNull("Id is null", lis);
    }

    @Test(priority = 2)
    public void checkFindById() {
        List<UserTrademark> list = UsersTrademarkDaoImpl.getInstance().findAll();
        for (UserTrademark li : list) {
            UserTrademark lis = UsersTrademarkDaoImpl.getInstance().findById(li.getId());
            assertNotNull("Id is null", lis);
        }
    }

    @Test(priority = 3)
    public void findAll() {
        List<UserTrademark> list = UsersTrademarkDaoImpl.getInstance().findAll();
        assertNotNull("Id is null", list);
    }

    @Test(priority = 5)
    public void delete() {
        List<UserTrademark> list = UsersTrademarkDaoImpl.getInstance().findAll();
        for (UserTrademark li : list) {
            UsersTrademarkDaoImpl.
                    getInstance().
                    delete(UsersTrademarkDaoImpl.getInstance().findById(li.getId()));
        }
        assertTrue(!list.isEmpty());
    }

}