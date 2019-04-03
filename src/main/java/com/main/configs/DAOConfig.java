package com.main.configs;


import com.main.authentication.UserCandidate;
import com.main.dao.ProductDAO;
import com.main.dao.UserCandidateDAO;
import com.main.shop.entities.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DAOConfig {

    @Bean
    public UserCandidateDAO userCandidateDAO() {
        return new UserCandidateDAO(UserCandidate.class);
    }
    @Bean
    public ProductDAO productDAO() {
        return new ProductDAO(Product.class);
    }
}
