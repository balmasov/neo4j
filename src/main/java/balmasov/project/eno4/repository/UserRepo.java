package balmasov.project.eno4.repository;

import balmasov.project.eno4.entity.neo4j.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends Neo4jRepository<User, Long> {
}
