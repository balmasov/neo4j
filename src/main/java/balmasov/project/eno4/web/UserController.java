package balmasov.project.eno4.web;

import balmasov.project.eno4.service.UserService;
import balmasov.project.eno4.web.request.ConnectionUsers;
import balmasov.project.eno4.web.request.UserWithChlamydiaRequest;
import balmasov.project.eno4.web.response.UserWithChlamydiaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/neo4j/example", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PutMapping(value = "/chlamydia/group")
    public List<UserWithChlamydiaResponse> createNewChlamydiaGroup(
            @RequestBody List<UserWithChlamydiaRequest> chlamydiaUsers) {
        return userService.createChlamydiaGroup(chlamydiaUsers);
    }

    @PostMapping(value = "/user/connection")
    public void createNewConnection(@RequestBody ConnectionUsers connectionUsers) {
        userService.createConnection(connectionUsers);
    }

    @PutMapping(value = "/user/create")
    public Long createNewUser(@RequestParam("login") String login) {
        return userService.createUser(login);
    }
}
