package org.project.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.project.entity.License;
import org.project.entity.Users;
import org.project.entity.UsersLicense;
import org.project.manager.SessionFactoryManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UsersLicenseDaoImplTest {

    private static final SessionFactory SESSION_FACTORY = SessionFactoryManager.getSessionFactory();

    @AfterClass
    public static void after() {
        SESSION_FACTORY.close();
    }

    @Before
    public void cleanEntity() {
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from UsersLicense");
            session.getTransaction().commit();
        }
    }

    @Test(priority = 1)
    public void checkSaveEntity() {
        Users list = new Users();
        list.setName("Save");
        UsersDaoImpl.getInstance().save(list);
        License license = new License();
        license.setArticle("Save");
        license.setTitle("Save");
        LicenseDaoImpl.getInstance().save(license);
        UsersLicense usersLicense = new UsersLicense();
        usersLicense.setUsers(list);
        usersLicense.setLicense(license);
        Serializable lis = UsersLicenseDaoImpl.getInstance().save(usersLicense);
        assertNotNull("Id is null", lis);
    }

    @Test(priority = 2)
    public void checkFindById() {
        List<UsersLicense> list = UsersLicenseDaoImpl.getInstance().findAll();
        for (UsersLicense li : list) {
            UsersLicense ln = UsersLicenseDaoImpl.getInstance().findById(li.getId());
            assertNotNull("Id is null", ln);
        }
    }

    @Test(priority = 3)
    public void findAll() {
        List<UsersLicense> list = UsersLicenseDaoImpl.getInstance().findAll();
        assertNotNull("Id is null", list);
    }

    @Test(priority = 5)
    public void delete() {
        List<UsersLicense> list = UsersLicenseDaoImpl.getInstance().findAll();
        for (UsersLicense li : list) {
            UsersLicenseDaoImpl.
                    getInstance().
                    delete(UsersLicenseDaoImpl.getInstance().findById(li.getId()));
        }
        assertTrue(!list.isEmpty());
    }

}