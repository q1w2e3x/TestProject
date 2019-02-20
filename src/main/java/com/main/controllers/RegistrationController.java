package com.main.controllers;

import com.main.authentification.UserCandidate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/registration")
public class RegistrationController  {

    // Запрос на форму регистрации
    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("userCandidate", new UserCandidate());
        return "registration/registr-form";
    }

    // Обработка формы
    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("userCandidate") UserCandidate candidate, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration/registr-form";
        }
        else {
            candidate.setRegistrationDate(LocalDate.now());

            // Тут будет генерация кода, отправка почтового подтверждения и занесение кандидата в БД

            return "registration/form-confirmation";
        }
    }
}
