package com.crystal.SpringBootPractise.dao;

import com.crystal.SpringBootPractise.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao {

    void updateProduct(Product product);
}
