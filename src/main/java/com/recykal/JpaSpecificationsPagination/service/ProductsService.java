package com.recykal.JpaSpecificationsPagination.service;

import com.recykal.JpaSpecificationsPagination.entity.Products;
import com.recykal.JpaSpecificationsPagination.repository.ProductsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductsService
{
    private final ProductsRepo productsRepo;


    public Products addProduct(Products product) {
        return productsRepo.save(product);
    }

    public Products deleteProduct(int id) throws IOException
    {
        Optional<Products> product = productsRepo.findById(id);
        productsRepo.deleteById(id);
        return product.get();
    }

    public Products updateProduct(int id, Products product) throws IOException {
        //Optional<Products> oldProduct = paginationRepo.findById(id);
        product.setId(id);
        return productsRepo.save(product);
    }

    public Products viewProduct(int id) {
        return productsRepo.findById(id).get();
    }

    public List<Products> allProducts()
    {
        return productsRepo.findAll();
    }

    public List<Products> sortedProducts(String field) {
        return productsRepo.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public Page<Products> pagination(int offset, int pageSize)
    {
        return productsRepo.findAll(PageRequest.of(offset,pageSize));
    }
}
