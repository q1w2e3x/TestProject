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

    @RequestMapping("/")
    public String showPage() {

        return "index";
    }
}
