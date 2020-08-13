package com.example.test.service;

import com.example.test.entity.Product;
import com.example.test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }


    public void save(Product product){
        productRepository.save(product);

    }
    public Product get(int id){
        return productRepository.findById(id).get();

    }

    public void delete(int id){
        productRepository.deleteById(id);

    }

}
