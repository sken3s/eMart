package com.example.emart;


import com.example.emart.product.Product;
import com.example.emart.product.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class ProductRepositoryTest {
    @Autowired private ProductRepository repo;

    @Test
    public void testAddNew(){
        Product product = new Product();
        product.setName("iPhone 13 Pro Max");
        product.setBrand("Apple");
        product.setType("Mobile Phone");
        product.setUnitPrice(10.91);
        product.setAvailableQuantity(15);

        Product savedProduct = repo.save(product);

        Assertions.assertThat(savedProduct).isNotNull();
        Assertions.assertThat(savedProduct.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<Product> products = repo.findAll();
        Assertions.assertThat(products).hasSizeGreaterThan(0);

        for(Product product:products){
            System.out.println(product);
        }
    }

    @Test
    public void testUpdate(){
        Integer productId =1;
        Optional<Product> optionalProduct = repo.findById(productId);
        Product product = optionalProduct.get();
        product.setAvailableQuantity(17);
        repo.save(product);

        Product updatedProduct = repo.findById(productId).get();
        Assertions.assertThat(updatedProduct.getAvailableQuantity()).isEqualTo(17);
    }

    @Test
    public void testGet(){
        Integer productId =1;
        Optional<Product> optionalProduct = repo.findById(productId);

        Assertions.assertThat(optionalProduct).isPresent();
        System.out.println(optionalProduct.get());
    }

//    @Test
//    public void testDelete(){
//        Integer productId =3;
//        repo.deleteById(productId);
//
//        Optional<Product> optionalProduct = repo.findById(productId);
//        Assertions.assertThat(optionalProduct).isNotPresent();
//    }
}
