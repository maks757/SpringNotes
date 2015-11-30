package org.guts.service;

import org.guts.entity.User;
import org.guts.model.exceptions.FormException;
import org.guts.model.form.RegisterUserForm;
import org.guts.model.validation.RegisterUserFormValidation;
import org.guts.repository.NotesRepository;
import org.guts.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Gutsulyak Vadim <guts.vadim@gmail.com>.
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public User findUserById(Long id) {
        return usersRepository.findOne(id);
    }

    @Override
    public Collection<User> findUsers() {
        return usersRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        usersRepository.delete(id);
    }

    @Override
    public void save(User user) {
        usersRepository.save(user);
    }

    @Override
    public void register(RegisterUserForm model) throws FormException {
        RegisterUserFormValidation validator = new RegisterUserFormValidation();
        MapBindingResult err = new MapBindingResult(new HashMap<String, String>(), RegisterUserForm.class.getName());
        validator.validate(model, err);
        List<ObjectError> errList = err.getAllErrors();

        if(!errList.isEmpty()) {
            throw new FormException(errList);
        }
        else {
            User user = new User(model.getUsername(), model.getPassword());
            usersRepository.save(user);
        }
    }
}
