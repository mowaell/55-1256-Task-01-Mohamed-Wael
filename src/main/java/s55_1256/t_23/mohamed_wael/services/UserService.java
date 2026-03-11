package s55_1256.t_23.mohamed_wael.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import s55_1256.t_23.mohamed_wael.models.User;
import s55_1256.t_23.mohamed_wael.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return user;
    }

    public User getUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return user;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String id, User user) {
        User updated = userRepository.update(id, user).orElse(null);
        if (updated == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return updated;
    }

    public void deleteUser(String id) {
        boolean deleted = userRepository.deleteById(id);
        if (!deleted) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }
}
