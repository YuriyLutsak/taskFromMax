package org.example;

import org.example.entity.Product;
import org.example.entity.ProductVersion;
import org.example.productDAO.ConfigEntityManager;
import org.example.productDAO.ProductRepository;
import org.example.productDAO.ProductVersionRepository;

import java.util.List;

public class App {
    public static void main(String[] args) {

        ProductRepository productRepository = new ProductRepository();
        ProductVersionRepository versionRepository = new ProductVersionRepository();

        Product product1 = new Product();
        product1.setName("product with entityManager");
        product1.setPrice(999);

        productRepository.save(product1);
        product1.setName("new name");

        ProductVersion version1 = new ProductVersion();
        version1.setVersion(99);
        version1.setCreator("big");
        version1.setDetails("bigDetails");
        version1.setProduct(product1);

        ProductVersion version2 = new ProductVersion();
        version2.setVersion(88);
        version2.setCreator("small");
        version2.setDetails("smallDetails");
        version2.setProduct(product1);
        product1.setProductVersion(List.of(version1, version2));

        productRepository.save(product1);
        System.out.println(product1);

        Product productFromDB = productRepository.findById(product1.getId());
        System.out.println(productFromDB);
        List<ProductVersion> productVersions = versionRepository.findAll();
        System.out.println(productVersions);

        productRepository.delete(productFromDB);
        System.out.println(productRepository.findAll());
        System.out.println(versionRepository.findAll());

        ConfigEntityManager.close();
    }
}
