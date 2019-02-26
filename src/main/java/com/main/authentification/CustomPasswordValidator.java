package com.main.authentification;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.lang.Character.isDigit;


// Password custom validation rule via Bean Validation Api
public class CustomPasswordValidator implements ConstraintValidator<ValidPassword, String> {

   public void initialize(ValidPassword constraint) {
   }


   public boolean isValid(String password, ConstraintValidatorContext context) {
      if (password == null) return false;

      // Password must contain one uppercase/lowercase latin letter and one digit
      // Only Latin letters
      boolean uppercaseCheck = false, lowercaseCheck = false, digitCheck = false;
      for (Character character :
              password.toCharArray()) {
         if (isLatinUppercase(character)) uppercaseCheck = true;
         else if (isLatinLowercase(character)) lowercaseCheck = true;
         else if (isDigit(character)) digitCheck = true;
         else return false;
      }
      return uppercaseCheck && lowercaseCheck && digitCheck;
   }

   private boolean isLatinLowercase(Character character) {
      return (character >= 'a' && character <= 'z');
   }

   private boolean isLatinUppercase(Character character) {
      return (character >= 'A' && character <= 'Z');
   }
}
