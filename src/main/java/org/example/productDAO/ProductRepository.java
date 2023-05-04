package org.example.productDAO;

import org.example.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;
import java.util.UUID;

public class ProductRepository {

    private final SessionFactory sessionFactory;

    public ProductRepository() {
        sessionFactory = ConfigSessionFactory.getSessionFactory();
    }

    public void save(Product product){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(product);

        transaction.commit();
        session.close();
    }

    public void update(Product product){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        if (product == null) {
            throw new RuntimeException("Current object didnt saved before");
        }
        session.merge(product);

        transaction.commit();
        session.close();
    }

    public List<Product> findAll(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<Product> query = session.createQuery("from Product", Product.class);
        List<Product> list = query.list();

        transaction.commit();
        session.close();

        return list;
    }

    public Product findById(UUID id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Product product = session.find(Product.class, id);

        transaction.commit();
        session.close();

        return product;
    }

    public void delete(Product product){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.remove(product);

        transaction.commit();
        session.close();
    }
}
