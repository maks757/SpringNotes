package org.guts.service;

import org.guts.entity.User;
import org.guts.model.exceptions.FormException;
import org.guts.model.form.RegisterUserForm;

import java.util.Collection;

/**
 * Created by Gutsulyak Vadim <guts.vadim@gmail.com>.
 */
public interface UsersService {
    User findUserById(Long id);
    Collection<User> findUsers();
    void delete(Long id);
    void save(User user);
    void register(RegisterUserForm model) throws FormException;
    User getCurrentUser();
}
