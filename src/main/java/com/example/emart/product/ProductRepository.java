package com.example.emart.product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer> {
public Long countById(Integer id);
}
