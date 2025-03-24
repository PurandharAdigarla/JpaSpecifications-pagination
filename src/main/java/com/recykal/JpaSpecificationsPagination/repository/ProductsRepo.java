package com.recykal.JpaSpecificationsPagination.repository;

import com.recykal.JpaSpecificationsPagination.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductsRepo extends JpaRepository<Products, Integer> {
    Optional<Products> findById(Integer id);
}
