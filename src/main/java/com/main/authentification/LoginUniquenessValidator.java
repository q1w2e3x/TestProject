package com.main.authentification;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class LoginUniquenessValidator implements ConstraintValidator<UniqueUser, String> {
   public void initialize(UniqueUser constraint) {

   }


   // We should also check user table for unique logins, but we haven't got such table yet

   public boolean isValid(String login, ConstraintValidatorContext context) {
      try (SessionFactory factory = new Configuration().configure().addAnnotatedClass(UserCandidate.class).buildSessionFactory()){
         Session session = factory.getCurrentSession();
         session.beginTransaction();
         List list = session.createQuery("from UserCandidate where login='" + login + "'" ).getResultList();
         session.getTransaction().commit();
         if (list != null && list.size() > 0) return false;
         else return true;
      }
      catch (Exception e) {
         System.out.println("Failed to check login uniqueness");
         e.printStackTrace();
         return false;
      }
   }
}
