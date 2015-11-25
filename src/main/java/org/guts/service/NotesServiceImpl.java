package org.guts.service;

import org.guts.entity.Note;
import org.guts.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesRepository notesRepository;

    @Override
    public Note findNoteById(Long id) {
        return notesRepository.findOne(id);
    }

    @Override
    public Collection<Note> findNotes() {
        return notesRepository.findAll();
    }

    @Override
    public void saveNote(Note note) {
        notesRepository.save(note);
    }
}
