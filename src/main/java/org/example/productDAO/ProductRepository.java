package org.example.productDAO;

import org.example.entity.Product;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

public class ProductRepository {

    private final EntityManager entityManager;

    public ProductRepository() {
        entityManager = ConfigEntityManager.getEntityManager();
    }

    public void save(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    public List<Product> findAll() {
        entityManager.getTransaction().begin();

        var query = entityManager.createQuery("from Product", Product.class);
        List<Product> list = query.getResultList();

        entityManager.getTransaction().commit();

        return list;
    }

    public Product findById(UUID id) {
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        entityManager.getTransaction().commit();

        return product;
    }

    public void delete(Product product) {
        entityManager.getTransaction().begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }
}
