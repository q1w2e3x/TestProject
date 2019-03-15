package com.main.configs;


import com.main.authentication.UserCandidate;
import com.main.dao.UserCandidateDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DAOConfig {

    @Bean
    public UserCandidateDAO userCandidateDAO() {
        return new UserCandidateDAO(UserCandidate.class);
    }
}
