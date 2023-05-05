package org.example.productDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConfigEntityManager {

    private static EntityManagerFactory managerFactory;
    private static EntityManager entityManager;

    private ConfigEntityManager() {
       managerFactory = Persistence.createEntityManagerFactory("my");
       entityManager = managerFactory.createEntityManager();
    }

    public static EntityManager getEntityManager() {
       if (entityManager != null) return entityManager;

       new ConfigEntityManager();

       return entityManager;
    }

    public static void close(){
        entityManager.close();
        managerFactory.close();
    }
}
