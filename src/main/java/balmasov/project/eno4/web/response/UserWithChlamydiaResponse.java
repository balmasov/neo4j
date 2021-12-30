package balmasov.project.eno4.web.response;

import balmasov.project.eno4.entity.neo4j.User;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserWithChlamydiaResponse {

    private Long userId;

    public UserWithChlamydiaResponse(User user) {
        this.userId = user.getId();
    }
}
