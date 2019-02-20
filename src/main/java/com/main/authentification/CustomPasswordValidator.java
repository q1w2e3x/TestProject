package com.main.authentification;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.lang.Character.isDigit;


// Валидатор для проверки пароля с помощью Bean Validation Api
public class CustomPasswordValidator implements ConstraintValidator<ValidPassword, String> {

   // Не знаю, что тут инициализировать стоит
   public void initialize(ValidPassword constraint) {
   }


   public boolean isValid(String password, ConstraintValidatorContext context) {
      if (password == null) return false;

      // Пароль должен содержать одну букву нижниего/верхнего регистра и цифру
      // Только латинские буквы
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
