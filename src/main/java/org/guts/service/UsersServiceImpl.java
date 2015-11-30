package org.guts.service;

import org.guts.entity.User;
import org.guts.repository.NotesRepository;
import org.guts.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * Created by Gutsulyak Vadim <guts.vadim@gmail.com>.
 */
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
}
