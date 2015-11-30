package org.guts.controllers;

import org.guts.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Gutsulyak Vadim <guts.vadim@gmail.com>.
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("cpassword") String cpassword
    ) {
        try {
            usersService.register(username, password, cpassword);
        }
        catch (SecurityException ex) {
            return "register";
        }
        return "register_success";
    }
}
