package com.main.controllers;

import com.main.authentication.UserCandidate;
import com.main.dao.GenericDAO;
import com.main.dao.UserCandidateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class HomeController {

    @Autowired
    GenericDAO userCandidateDAO;

    // We will actually do testing here lul
    @RequestMapping("/")
    public String showPage() {

        // Testing UserCandidateDAO

        System.out.println("Creating user candidate");
        UserCandidate uc = new UserCandidate();
        uc.setLogin("PFSAPFASP");
        uc.setEmail("fdsfd@mafds.ru");
        uc.setPassword("123445678aA");
        uc.setPhone("+77777777777");
        uc.setRegistrationDate(LocalDate.now());
        uc.setConfirmCode("fdsfdsfd");
        userCandidateDAO.create(uc);
        System.out.println("User candidate created: " + uc);

        // ONLY WORKS PARTIALLY, TRIES TO SAVE MULTIPLE TIMES FOR WHATEVER REASON
        // BUT STILL SAVES AS EXPECTED

        return "index";
    }
}
