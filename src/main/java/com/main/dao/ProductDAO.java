package com.main.dao;

import com.main.authentication.UserCandidate;
import com.main.shop.entities.Product;

public class ProductDAO extends HibernateGenericDAOImpl<Product, Integer> {
    public ProductDAO(Class<Product> typeParameterClass) {
        super(typeParameterClass);
    }
}
