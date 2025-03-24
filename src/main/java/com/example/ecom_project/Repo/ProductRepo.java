package com.example.ecom_project.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecom_project.Model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
    
}