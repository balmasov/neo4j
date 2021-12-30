package balmasov.project.eno4.service;

import balmasov.project.eno4.web.request.ConnectionUsers;
import balmasov.project.eno4.web.request.UserWithChlamydiaRequest;
import balmasov.project.eno4.web.response.UserWithChlamydiaResponse;

import java.util.List;

public interface UserService {
    List<UserWithChlamydiaResponse> createChlamydiaGroup(List<UserWithChlamydiaRequest> chlamydiaUsers);


    void createConnection(ConnectionUsers connectionUsers);

    Long createUser(String login);
}
