package com.sub.learner.jpamultipleds.dao.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sub.learner.jpamultipleds.model.product.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}