package balmasov.project.eno4.service.impl;

import balmasov.project.eno4.entity.neo4j.User;
import balmasov.project.eno4.entity.neo4j.VenerealDisease;
import balmasov.project.eno4.entity.neo4j.enums.DiseaseNames;
import balmasov.project.eno4.repository.DiseaseRepo;
import balmasov.project.eno4.service.VenerealDiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VenerealDiseaseServiceImpl implements VenerealDiseaseService {

    private final DiseaseRepo diseaseRepo;

    @Override
    public void addPatientsToChlamydia(List<User> users) {
        VenerealDisease chlamydia = createOrGetChlamydia();
        chlamydia.getPotentiallyDead().addAll(users);

        diseaseRepo.save(chlamydia);
    }

    private VenerealDisease createOrGetChlamydia() {
        return diseaseRepo.findById(DiseaseNames.CHLAMYDIA.name())
                .orElse(createDisease(DiseaseNames.CHLAMYDIA));
    }

    private VenerealDisease createDisease(DiseaseNames name) {
        return diseaseRepo.save(new VenerealDisease(name.name(), name.getInfo()));
    }
}
