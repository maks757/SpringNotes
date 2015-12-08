package org.guts.service;

import org.guts.entity.Note;

import java.util.Collection;

public interface NotesService {
    Note findNoteById(Long id);
    Collection<Note> findNotes();
    void saveNote(Note note);
    void remove(Long id);
    void createNote(String title, String text);
    void changeNote(Long id, String title, String text);
    void isNoteUser(Long idNotes);
}