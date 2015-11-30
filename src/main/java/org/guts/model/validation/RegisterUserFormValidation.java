package org.guts.model.validation;

import org.guts.model.form.RegisterUserForm;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Gutsulyak Vadim <guts.vadim@gmail.com>.
 */
public class RegisterUserFormValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterUserForm model = (RegisterUserForm)target;

        if (model.getUsername().length() < 4 || model.getUsername().length() > 20) {
            errors.rejectValue("username", "username.length", "Username length must be between 4 and 20");
        }
        if (model.getPassword().length() < 4 || model.getPassword().length() > 20) {
            errors.rejectValue("password", "password.length", "Password length must be between 4 and 20");
        }
        else if (!model.getPassword().equals(model.getCpassword())) {
            errors.rejectValue("cpassword", "cpassword", "Password confirmation is wrong!");
        }

    }
}
