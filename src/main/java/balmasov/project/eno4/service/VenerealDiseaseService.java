package balmasov.project.eno4.service;

import balmasov.project.eno4.entity.neo4j.User;

import java.util.List;

public interface VenerealDiseaseService {

    void addPatientsToChlamydia(List<User> users);
}
