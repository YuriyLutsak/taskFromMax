package org.example.productDAO;

import org.example.entity.Product;
import org.example.entity.ProductVersion;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class ConfigSessionFactory {

    private static SessionFactory sessionFactory;

    private ConfigSessionFactory() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory != null) {
            return sessionFactory;
        }

        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(ProductVersion.class);

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());

        return sessionFactory;
    }
}
