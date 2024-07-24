package com.example.shop.Controller;

import com.example.shop.Service.ProductService;
import com.example.shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")

public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/create_product")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    @GetMapping("/getProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/productById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product=productService.getProductById(Math.toIntExact(id));
        return product!=null?ResponseEntity.ok(product):ResponseEntity.notFound().build();
    }
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct=productService.updateProduct(id, product);
        return updatedProduct!=null?ResponseEntity.ok(updatedProduct):ResponseEntity.notFound().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
