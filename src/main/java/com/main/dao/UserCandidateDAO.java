package com.main.dao;

import com.main.authentication.UserCandidate;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserCandidateDAO extends HibernateGenericDAOImpl<UserCandidate, Integer> {

    public UserCandidateDAO(Class<UserCandidate> typeParameterClass) {
        super(typeParameterClass);
    }
}
