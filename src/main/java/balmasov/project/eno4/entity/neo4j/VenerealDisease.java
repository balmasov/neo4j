package balmasov.project.eno4.entity.neo4j;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;

@Data
@EqualsAndHashCode(exclude = {"potentiallyDead"})
@ToString(exclude = {"potentiallyDead"})
@Node("Disease")
public class VenerealDisease {

    @Id
    private final String title;

    /**
     * The @Property annotation is used as a way for mapping
     * a different name for the field than for the graph property.
     */
    @Property("description")
    private final String venerealInfo;

    @Relationship(type = "PATIENTS", direction = INCOMING)
    private Set<User> potentiallyDead = new HashSet<>();
}
