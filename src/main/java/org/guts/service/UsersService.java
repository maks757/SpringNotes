package org.guts.service;

import org.guts.entity.User;

import java.util.Collection;

/**
 * Created by Gutsulyak Vadim <guts.vadim@gmail.com>.
 */
public interface UsersService {
    User findUserById(Long id);
    Collection<User> findUsers();
    void delete(Long id);
    void save(User user);
}
