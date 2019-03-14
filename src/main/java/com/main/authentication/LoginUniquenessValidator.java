package com.main.authentication;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;


// Checks that login is unique in both UserCandidate And User entities

public class LoginUniquenessValidator implements ConstraintValidator<UniqueUser, String> {

   public void initialize(UniqueUser constraint) {}

   public boolean isValid(String login, ConstraintValidatorContext context) {
      try (SessionFactory factory = new Configuration().configure().addAnnotatedClass(UserCandidate.class).buildSessionFactory();
               Session session = factory.getCurrentSession()){

         session.beginTransaction();

         // We only check UserCandidate entity login uniqueness, since we haven't implemented User yet

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
