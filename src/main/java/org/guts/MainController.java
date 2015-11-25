package org.guts;

import org.guts.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/notes/{noteId}")
    public String note(@PathVariable(value = "noteId") long noteId, Model model) {
        model.addAttribute("note", notesService.findNoteById(noteId));
        return "note";
    }

}