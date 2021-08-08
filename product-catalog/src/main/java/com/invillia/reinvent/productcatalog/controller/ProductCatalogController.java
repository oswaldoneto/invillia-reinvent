package com.invillia.reinvent.productcatalog.controller;

import com.invillia.reinvent.productcatalog.entity.Product;
import com.invillia.reinvent.productcatalog.repository.ProductCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/")
public class ProductCatalogController {

    @Autowired
    private ProductCatalogRepository productCatalogRepository;

    @GetMapping(value = "/")
    public List<Product> getProducts() {
        Iterable<Product> iterable = productCatalogRepository.findAll();
        List<Product> productList = StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
        return productList;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id")  String id) {
        Optional<Product> productOptional = productCatalogRepository.findById(id);
        if (productOptional.isPresent()) {
            return ResponseEntity.ok().body(productOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/")
    public Product createProduct(@RequestBody Product product) {
        return productCatalogRepository.save(product);
    }

}
