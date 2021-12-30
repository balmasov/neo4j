package balmasov.project.eno4.entity.neo4j;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.neo4j.core.schema.*;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;
import static org.springframework.data.neo4j.core.schema.Relationship.Direction.OUTGOING;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(exclude = {"connection", "disease"})
@ToString(exclude = {"connection", "disease"})
@Node("User")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Property("login")
    private String login;

    @Relationship(type = "SEXUAL_INTERCOURSE")
    private Set<User> connection = new HashSet<>();

    @Relationship(type = "DIRECTED")
    private Set<VenerealDisease> disease = new HashSet<>();
}

