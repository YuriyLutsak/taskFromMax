package org.example.productDAO;

import org.example.entity.ProductVersion;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

public class ProductVersionRepository {

    private final EntityManager entityManager;

    public ProductVersionRepository() {
        entityManager = ConfigEntityManager.getEntityManager();
    }

    public void save(ProductVersion productVersion) {
        entityManager.getTransaction().begin();
        entityManager.persist(productVersion);
        entityManager.getTransaction().commit();
    }

    public List<ProductVersion> findAll() {
        entityManager.getTransaction().begin();

        var query = entityManager.createQuery("from ProductVersion", ProductVersion.class);
        var result = query.getResultList();

        entityManager.getTransaction().commit();

        return result;
    }

    public ProductVersion findById(UUID id){
        entityManager.getTransaction().begin();
        var versionId = entityManager.find(ProductVersion.class, id);
        entityManager.getTransaction().commit();

        return versionId;
    }

    public void delete(ProductVersion productVersion){
        entityManager.getTransaction().begin();
        entityManager.remove(productVersion);
        entityManager.getTransaction().commit();
    }
}
