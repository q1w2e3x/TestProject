package com.main.controllers;

import com.main.authentification.UserCandidate;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

@Controller
@RequestMapping("/registration")
public class RegistrationController  {

    // Show registration form
    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("userCandidate", new UserCandidate());
        return "registration/registr-form";
    }

    // Process registration form
    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("userCandidate") UserCandidate candidate, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration/registr-form";
        }
        else {
            candidate.setRegistrationDate(LocalDate.now());
            candidate.setConfirmCode(RandomStringUtils.randomAlphanumeric(7).toLowerCase());

            // saving user candidate to database

            try (SessionFactory factory = new Configuration().configure().addAnnotatedClass(UserCandidate.class).buildSessionFactory()){
                Session session = factory.getCurrentSession();
                session.beginTransaction();
                session.save(candidate);
                session.getTransaction().commit();
            }
            catch (Exception e) {
                System.out.println("Failed to save UserCandidate to database");
                e.printStackTrace();
            }

            // Instead of sending emails we temporary add links to links.txt
            try (BufferedWriter writer =
                         Files.newBufferedWriter(Paths.get("D:\\links.txt"), StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {

                writer.write("http://localhost:8080/registration/confirm?login=" + candidate.getLogin()
                        + "&code=" + candidate.getConfirmCode() + "\n");
                System.out.println("Wrote info to links.txt");
            }
            catch (IOException e) {
                System.out.println("Couldn't write link to the file");
            }

            return "registration/form-confirmation";
        }
    }

    // Registration confirmation

    @RequestMapping("/confirm")
    public String confirm() {
        return "registration/user-confirmation";
    }
}
