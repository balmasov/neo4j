package balmasov.project.eno4.web.request;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserWithChlamydiaRequest {

    private String login;
}
