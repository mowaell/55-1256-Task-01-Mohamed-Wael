package s55_1256.t_23.mohamed_wael.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import s55_1256.t_23.mohamed_wael.models.Note;
import s55_1256.t_23.mohamed_wael.services.NoteService;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/search")
    public List<Note> searchByTitle(@RequestParam String title) {
        return noteService.getAllNotes().stream()
                .filter(n -> n.getTitle().toLowerCase().contains(title.toLowerCase()))
                .toList();
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable String id) {
        return noteService.getNoteById(id);
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteService.createNote(note);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable String id, @RequestBody Note note) {
        return noteService.updateNote(id, note);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNote(@PathVariable String id) {
        noteService.deleteNote(id);
    }
}

