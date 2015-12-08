package org.guts.controllers;

import org.guts.entity.Note;
import org.guts.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private NotesService notesService;
    @RequestMapping("/")
    public String index(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        String message = "Hello " + name;

        model.addAttribute("message", message);
        return "index";
    }

    @RequestMapping("/notes")
    public String notes(Model model) {
        model.addAttribute("notes", notesService.findNotes());
        return "notes";
    }

    @RequestMapping(value = "/notes/add", method = RequestMethod.POST)
    public String addNote(@RequestParam("title") String title, @RequestParam("text") String text) {
        notesService.createNote(title, text);
        return "redirect:/notes";
    }

    @RequestMapping(value = "/notes/{noteId}", method = RequestMethod.GET)
    public String editNote(@PathVariable("noteId") Long noteId, Model model) {
            try {
                notesService.isNoteUser(noteId);
                model.addAttribute("note", notesService.findNoteById(noteId));
                return "note_edit";
            }
            catch (AccessDeniedException e){
                model.addAttribute("message_error", e.getMessage());
                return "error";
            }
    }

    @RequestMapping(value = "/notes/{noteId}", method = RequestMethod.POST)
    public String updateNote(
            @PathVariable("noteId") Long noteId,
            @RequestParam("title") String title,
            @RequestParam("text") String text) {
        notesService.changeNote(noteId, title, text);
        return "redirect:/notes";
    }

    @RequestMapping("/notes/remove/{noteId}")
    public String removeNote(@PathVariable("noteId") Long noteId, Model model) {
        try {
            notesService.remove(noteId);
            return "redirect:/notes";
        }
        catch (AccessDeniedException e)
        {
            model.addAttribute("message_error", e.getMessage());
            return "error";
        }
    }

}