package balmasov.project.eno4.entity.neo4j.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DiseaseNames {

    CHLAMYDIA("A very dangerous disease, you can die");

    private final String info;
}
