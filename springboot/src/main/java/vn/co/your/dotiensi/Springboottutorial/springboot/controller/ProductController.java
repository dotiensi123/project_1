package vn.co.your.dotiensi.Springboottutorial.springboot.controller;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.co.your.dotiensi.Springboottutorial.springboot.models.Product;
import vn.co.your.dotiensi.Springboottutorial.springboot.repositories.ProductRepository;

import java.util.List;
@RestController
@RequestMapping(path="api/v1/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;
    @GetMapping("/getproducts")
    public List<Product> getAllProduct(){
        return repository.findAll();
    }
}
