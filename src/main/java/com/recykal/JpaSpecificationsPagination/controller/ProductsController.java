package com.recykal.JpaSpecificationsPagination.controller;

import com.recykal.JpaSpecificationsPagination.dto.ResponseDto;
import com.recykal.JpaSpecificationsPagination.entity.Products;
import com.recykal.JpaSpecificationsPagination.exceptions.ProductNotFoundException;
import com.recykal.JpaSpecificationsPagination.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductsController
{
    private final ProductsService productsService;

    @PostMapping("/addProduct")
    ResponseEntity<Products> addProduct(@RequestBody Products product) {
        return new ResponseEntity<>(productsService.addProduct(product), HttpStatus.OK);
    }

    @GetMapping("/viewProduct/{id}")
    ResponseEntity<Products> viewProduct(@PathVariable int id) {
        return new ResponseEntity<>(productsService.viewProduct(id), HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{id}")
    ResponseEntity<Products> deleteProduct(@PathVariable int id){
        return new ResponseEntity<>(productsService.deleteProduct(id), HttpStatus.OK);
    }

    @PutMapping("/updateProduct/{id}")
    ResponseEntity<Products> updateProduct(@PathVariable int id, Products product) {
        return new ResponseEntity<>(productsService.updateProduct(id, product), HttpStatus.OK);
    }

    @GetMapping("/allProducts")
    ResponseEntity<ResponseDto<List<Products>>> allProducts() {
        List<Products> allProducts= productsService.allProducts();
        return new ResponseEntity<> (new ResponseDto<>(allProducts.size(),allProducts), HttpStatus.OK);
    }

    @GetMapping("/sorted/{field}")
    ResponseEntity<ResponseDto<List<Products>>> sortedProducts(@PathVariable String field) {
        List<Products> sortedProducts= productsService.sortedProducts(field);
        return new ResponseEntity<> (new ResponseDto<>(sortedProducts.size(), sortedProducts), HttpStatus.OK);
    }

    @GetMapping("/JpaSpecificationsPagination")
    ResponseEntity<ResponseDto<Page<Products>>> pagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Products> pagedProducts = productsService.pagination(offset,pageSize);
        return new ResponseEntity<>(new ResponseDto<>(pagedProducts.getSize(),pagedProducts), HttpStatus.OK);
    }
}
