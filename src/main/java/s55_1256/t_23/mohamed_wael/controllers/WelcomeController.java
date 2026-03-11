package s55_1256.t_23.mohamed_wael.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Value("${USER_NAME}")
    private String username;

    @Value("${ID}")
    private String id;

    @GetMapping("/welcome")
    public String welcome() {
        return "Hello " + username + " " + id + ", from Notes API";
    }
}
