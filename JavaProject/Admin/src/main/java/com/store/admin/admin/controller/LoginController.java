package com.store.admin.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
}
