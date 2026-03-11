package s55_1256.t_23.mohamed_wael.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import s55_1256.t_23.mohamed_wael.models.Note;
import s55_1256.t_23.mohamed_wael.repositories.NoteRepository;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(String id) {
        Note note = noteRepository.findById(id).orElse(null);
        if (note == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found");
        }
        return note;
    }

    public List<Note> getNotesByUserId(String userId) {
        List<Note> notes = noteRepository.findByUserId(userId);
        if (notes.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No notes found for user");
        }
        return notes;
    }

    public Note getNoteByTitle(String title) {
        Note note = noteRepository.findByTitle(title).orElse(null);
        if (note == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No notes found with that title");
        }
        return note;
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Note updateNote(String id, Note note) {
        Note updated = noteRepository.update(id, note).orElse(null);
        if (updated == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found");
        }
        return updated;
    }

    public void deleteNote(String id) {
        boolean deleted = noteRepository.deleteById(id);
        if (!deleted) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found");
        }
    }
}

