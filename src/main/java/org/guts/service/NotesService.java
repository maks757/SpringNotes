package org.guts.service;

import org.guts.entity.Note;

import java.util.Collection;

public interface NotesService {
    Note findNoteById(Long id);
    Collection<Note> findNotes();
    void saveNote(Note note);
}