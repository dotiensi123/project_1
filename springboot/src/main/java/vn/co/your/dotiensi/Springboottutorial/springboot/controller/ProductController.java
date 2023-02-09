package vn.co.your.dotiensi.Springboottutorial.springboot.controller;

import jakarta.persistence.Entity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.co.your.dotiensi.Springboottutorial.springboot.models.Product;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/products")
public class ProductController {
//    private Long id;
//    private String ProductName;
//    private int year;
//    private Double price;
//    private String url;
    @GetMapping("/getproducts")
    public List<Product> getAllProduct(){
        return List.of(
                new Product(1L,"dotiensi",2022,122.3,"")
        );
    }
}
