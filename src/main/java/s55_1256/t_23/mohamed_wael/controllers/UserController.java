package s55_1256.t_23.mohamed_wael.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import s55_1256.t_23.mohamed_wael.models.Note;
import s55_1256.t_23.mohamed_wael.models.User;
import s55_1256.t_23.mohamed_wael.services.NoteService;
import s55_1256.t_23.mohamed_wael.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final NoteService noteService;

    public UserController(UserService userService, NoteService noteService) {
        this.userService = userService;
        this.noteService = noteService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/search")
    public User searchByUsername(@RequestParam String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}/notes")
    public List<Note> getNotesByUserId(@PathVariable String id) {
        return noteService.getNotesByUserId(id);
    }
}
