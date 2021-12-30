package balmasov.project.eno4.repository;

import balmasov.project.eno4.entity.neo4j.VenerealDisease;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepo extends Neo4jRepository<VenerealDisease, String> {
}
