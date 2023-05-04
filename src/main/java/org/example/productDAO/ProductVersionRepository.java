package org.example.productDAO;

import org.example.entity.ProductVersion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;
import java.util.UUID;

public class ProductVersionRepository {

    private final SessionFactory sessionFactory;

    public ProductVersionRepository() {
        sessionFactory = ConfigSessionFactory.getSessionFactory();
    }

    public void save(ProductVersion productVersion) {
        Session session = sessionFactory.openSession();
        Transaction trCreate = session.beginTransaction();

        session.persist(productVersion);

        trCreate.commit();
        session.close();
    }

    public void update(ProductVersion productVersion){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        if (productVersion.getId() == null) {
            throw new RuntimeException("Current object didnt saved before");
        }
        session.merge(productVersion);

        transaction.commit();
        session.close();
    }

    public List<ProductVersion> findAll() {
        List<ProductVersion> versionList;

        Session session = sessionFactory.openSession();
        Transaction trFindAll = session.beginTransaction();

        Query<ProductVersion> query = session.createQuery("from ProductVersion", ProductVersion.class);
        versionList = query.list();

        trFindAll.commit();
        session.close();

        return versionList;
    }

    public void delete(ProductVersion productVersion) {
        Session session = sessionFactory.openSession();
        Transaction trDelete = session.beginTransaction();

        session.remove(productVersion);

        trDelete.commit();
        session.close();
    }

    public ProductVersion findById(UUID id) {
        Session session = sessionFactory.openSession();
        Transaction trFind = session.beginTransaction();

        ProductVersion productVersion = session.find(ProductVersion.class, id);

        trFind.commit();
        session.close();

        return productVersion;
    }
}
