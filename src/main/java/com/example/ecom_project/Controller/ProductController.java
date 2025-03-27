package com.example.ecom_project.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecom_project.Model.Product;
import com.example.ecom_project.Service.ProductService;

@RestController
@RequestMapping("/api")
// @CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        System.out.println("Inside /products");
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        System.out.println("Inside /product/{id}");
        Product product = service.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getProductImage(@PathVariable int id){
        Product product = service.getProductById(id);
        MediaType mediaType = MediaType.valueOf(product.getImageType());
        return ResponseEntity.ok().contentType(mediaType).body(product.getImageData());
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        try{
            Product p = service.addProduct(product, imageFile);
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @PutMapping("/product")
    // public ResponseEntity<String> updateProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
    //     Product p = service.getProductById(product.getId());
    //     if(p==null){
    //         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    //     }

    //     try{
    //         service.updateProduct(product, imageFile);
    //         return new ResponseEntity<>("Product Update Successful", HttpStatus.OK);
    //     } 
    //     catch (IOException e) {
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product, @RequestPart MultipartFile imageFile) {

        Product product1 = null;
        try {
            product1 = service.updateProduct(id, product, imageFile);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
        }
        if (product1 != null) {
            return new ResponseEntity<>("updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
        }


    }
}

