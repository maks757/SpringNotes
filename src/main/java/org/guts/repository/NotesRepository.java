package org.guts.repository;

import org.guts.entity.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface NotesRepository extends CrudRepository<Note, Long> {

    @Override
    Collection<Note> findAll();

    @Override
    Note findOne(Long id);

    @Override
    Note save(Note entity);

    @Override
    void delete(Long id);

}
