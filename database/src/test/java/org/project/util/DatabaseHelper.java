package org.project.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.project.entity.Menu;

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
        entityManager.createQuery("delete from Menu").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void prepareData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Menu menu = new Menu("Menu1");
        entityManager.persist(menu);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
