package com.afzal.crud.demo.service;

import com.afzal.crud.demo.entity.Product;
import com.afzal.crud.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    //POST Methods
    public Product saveProduct(Product product) {
        return repository.save(product);
    }
    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    //GET Methods
    public List<Product> getProducts() {
        return repository.findAll();
    }
    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    //PUT Methods
    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setId(product.getId());
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }
    
    public Product updatePatch(int id, String name, int quantity, double price) {
    	
    	Product existingProduct = repository.findById(id).orElse(null);
        
        if(name != null) existingProduct.setName(name);
        if(quantity != 0) existingProduct.setQuantity(quantity);
        if(price != 0) existingProduct.setPrice(price);
        return repository.save(existingProduct);
    }

    //DELETE Method
    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "Product Deleted" + " : " + id;
    }
}
