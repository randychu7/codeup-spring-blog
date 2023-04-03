package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.controllers.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long> {

}
