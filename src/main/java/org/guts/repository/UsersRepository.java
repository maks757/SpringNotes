package org.guts.repository;

import org.guts.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Created by Gutsulyak Vadim <guts.vadim@gmail.com>.
 */
public interface UsersRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    @Override
    User save(User user);

    @Override
    User findOne(Long id);

    @Override
    boolean exists(Long id);

    @Override
    Collection<User> findAll();

    @Override
    long count();

    @Override
    void delete(Long id);
}
