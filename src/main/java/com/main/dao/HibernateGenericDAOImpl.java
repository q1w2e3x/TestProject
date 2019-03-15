package com.main.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Repository
@Transactional
public abstract class HibernateGenericDAOImpl<T, PK extends Serializable>
                                        implements GenericDAO<T, PK> {

    @Autowired
    private SessionFactory sessionFactory;

    private final Class<T> typeParameterClass;

    public HibernateGenericDAOImpl(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    @Override
    public PK create(T newInstance) {
        return (PK) sessionFactory.getCurrentSession().save(newInstance);
    }

    @Override
    public T read(PK id) {
        return (T) sessionFactory.getCurrentSession().get(typeParameterClass, id);
    }

    @Override
    public void update(T transientObject) {
        sessionFactory.getCurrentSession().update(transientObject);
    }

    @Override
    public void delete(T persistentObject) {
        sessionFactory.getCurrentSession().delete(persistentObject);
    }
}
