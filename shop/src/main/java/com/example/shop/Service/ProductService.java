package com.example.shop.Service;

import com.example.shop.Repository.ProductRepository;
import com.example.shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

     @Autowired
     ProductRepository productRepository;
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product getProductById(int id) {
        return productRepository.findById(id).get();
    }
    public Product updateProduct(Long id, Product product) {
        if(productRepository.existsById(Math.toIntExact(id))){
            product.setId(id);
            return productRepository.save(product);
        }else{
            return null;
        }
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(Math.toIntExact(id));

    }
}
