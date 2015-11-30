package org.guts.controllers;

import org.guts.model.exceptions.FormException;
import org.guts.model.form.RegisterUserForm;
import org.guts.model.validation.RegisterUserFormValidation;
import org.guts.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gutsulyak Vadim <guts.vadim@gmail.com>.
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("model", new RegisterUserForm());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("model") RegisterUserForm model, Model viewModel) {

        try {
            usersService.register(model);
        } catch (FormException e) {
            viewModel.addAttribute("errors", e.getErrors());
            viewModel.addAttribute("model", model);
            return "register";
        }

        return "register_success";

    }
}
