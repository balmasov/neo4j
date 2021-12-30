package balmasov.project.eno4.service.impl;

import balmasov.project.eno4.entity.neo4j.User;
import balmasov.project.eno4.repository.UserRepo;
import balmasov.project.eno4.service.UserService;
import balmasov.project.eno4.service.VenerealDiseaseService;
import balmasov.project.eno4.web.request.ConnectionUsers;
import balmasov.project.eno4.web.request.UserWithChlamydiaRequest;
import balmasov.project.eno4.web.response.UserWithChlamydiaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final VenerealDiseaseService venerealDiseaseService;

    @Override
    @Transactional
    public List<UserWithChlamydiaResponse> createChlamydiaGroup(List<UserWithChlamydiaRequest> chlamydiaUsers) {

        List<User> savesUsers = userRepo.saveAll(
                chlamydiaUsers.stream()
                        .map(request -> new User().setLogin(request.getLogin()))
                        .collect(Collectors.toList())
        );

        venerealDiseaseService.addPatientsToChlamydia(savesUsers);

        return savesUsers.stream()
                .map(UserWithChlamydiaResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void createConnection(ConnectionUsers connectionUsers) {
        User user = userRepo.findById(connectionUsers.getExistingUserId())
                .orElseThrow(() -> new RuntimeException("The user does not exist"));

        List<User> allById = userRepo.findAllById(connectionUsers.getConnectedUsers());

        if (!CollectionUtils.isEmpty(allById)) user.getConnection().addAll(allById);

        userRepo.save(user);
    }

    @Override
    @Transactional
    public Long createUser(String login) {
        User save = userRepo.save(new User()
                .setLogin(login));

        return save.getId();
    }
}
