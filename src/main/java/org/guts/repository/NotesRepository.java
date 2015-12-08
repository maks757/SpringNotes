package org.guts.repository;

import org.guts.entity.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface NotesRepository extends CrudRepository<Note, Long> {

    List<Note> findByOwner_Username(String username);

    @Override
    Note findOne(Long id);

    @Override
    Note save(Note note);

    @Override
    Collection<Note> findAll();

    @Override
    long count();

    @Override
    void delete(Long id);
}
