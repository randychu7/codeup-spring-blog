package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long> {

}
