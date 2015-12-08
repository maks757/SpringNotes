package org.guts.service;

import org.guts.entity.Note;
import org.guts.entity.User;
import org.guts.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesRepository notesRepository;
    @Autowired
    private UsersService usersService;

    @Override
    public Note findNoteById(Long id) {
        return notesRepository.findOne(id);
    }

    @Override
    public Collection<Note> findNotes() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return notesRepository.findByOwner_Username(username);
    }

    @Override
    public void saveNote(Note note) {
        notesRepository.save(note);
    }

    @Override
    public void remove(Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Note note = notesRepository.findOne(id);
        String username_Note = note.getOwner().getUsername();
        if (!username.equals(username_Note))
            throw new AccessDeniedException("Page not found 404. Not deleted invalid index.");
        notesRepository.delete(id);
    }

    @Override
    public void createNote(String title, String text) {
        User currentUser = usersService.getCurrentUser();
        Note note = new Note(title, text, currentUser);
        notesRepository.save(note);
    }

    @Override
    public void changeNote(Long id, String title, String text) {
        Note note = notesRepository.findOne(id);
        note.setTitle(title);
        note.setText(text);

        notesRepository.save(note);
    }

    @Override
    public void isNoteUser(Long idNotes) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Note note = notesRepository.findOne(idNotes);
        String username_note = note.getOwner().getUsername();
        if (!username.equals(username_note))
            throw new AccessDeniedException("Page not found 404.");
    }
}
