package balmasov.project.eno4.web.request;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class ConnectionUsers {

    private Long existingUserId;

    private List<Long> connectedUsers;
}
