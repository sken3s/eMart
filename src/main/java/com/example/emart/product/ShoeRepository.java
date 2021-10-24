package com.example.emart.product;

import org.springframework.data.repository.CrudRepository;

public interface ShoeRepository extends CrudRepository<Shoe,Integer> {
public Long countById(Integer id);
}
