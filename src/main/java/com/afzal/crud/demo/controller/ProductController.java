package com.afzal.crud.demo.controller;

import com.afzal.crud.demo.entity.Product;
import com.afzal.crud.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }
    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }
    
    @PatchMapping("/update/{id}/{name}/{quantity}/{price}")
    public Product updateSpec(@PathVariable int id, @PathVariable String name, @PathVariable int quantity, @PathVariable double price) {
    	
    	return service.updatePatch(id, name, quantity, price);
		/*
		 * Product product = service.getProductById(id); product.setName(name); return
		 * service.saveProduct(product);
		 */
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}
