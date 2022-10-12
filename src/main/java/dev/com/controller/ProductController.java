package dev.com.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @RequestMapping("/queryById")
    public String getProductName(String id){
        return "Product"+id;
    }
}
