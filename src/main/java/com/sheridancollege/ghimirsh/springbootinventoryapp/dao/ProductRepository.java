package com.sheridancollege.ghimirsh.springbootinventoryapp.dao;

import com.sheridancollege.ghimirsh.springbootinventoryapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
