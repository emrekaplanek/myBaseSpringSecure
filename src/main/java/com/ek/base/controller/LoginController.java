package com.ek.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        return "bootstrap-login";
    }

    @GetMapping("/leaders")
    public String leaders() {

        return "leaders-page";
    }

    @GetMapping("/systems")
    public String systems() {

        return "systems-page";
    }

    @GetMapping("/access-denied")
    public String showDenialPage(){

        return  "access-denied";
    }
}
