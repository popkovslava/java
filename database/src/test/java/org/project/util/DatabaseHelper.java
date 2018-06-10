package org.project.util;

import org.project.entity.License;
import org.project.entity.Pages;
import org.project.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Component
public class DatabaseHelper {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public DatabaseHelper(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void cleanDatabase() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        //entityManager.createQuery("delete from Menu").executeUpdate();
        // entityManager.createQuery("delete from  License").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void prepareData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Pages page1 = new Pages("Nolan");
        Pages page2 = new Pages("Nolan");
        Pages page3 = new Pages("Nolan");
        Pages page4 = new Pages("Nolan");
        entityManager.persist(page1);
        entityManager.persist(page2);
        entityManager.persist(page3);
        entityManager.persist(page4);
        Menu menu1 = new Menu("Nolan");
        Menu menu2 = new Menu("Nolan");
        Menu menu3 = new Menu("Menu3");
        Menu menu4 = new Menu("Menu4");
        Menu menu5 = new Menu("Menu5");
        entityManager.persist(menu1);
        entityManager.persist(menu2);
        entityManager.persist(menu3);
        entityManager.persist(menu4);
        entityManager.persist(menu5);
        License license1 = new License();
        license1.setTitle("Licence1");
        License license2 = new License();
        license2.setTitle("Licence2");
        License license3 = new License();
        license3.setTitle("Licence3");
        License license4 = new License();
        license4.setTitle("Licence4");
        License license5 = new License();
        license5.setTitle("Licence4");
        entityManager.persist(license1);
        entityManager.persist(license2);
        entityManager.persist(license3);
        entityManager.persist(license4);
        entityManager.persist(license5);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
