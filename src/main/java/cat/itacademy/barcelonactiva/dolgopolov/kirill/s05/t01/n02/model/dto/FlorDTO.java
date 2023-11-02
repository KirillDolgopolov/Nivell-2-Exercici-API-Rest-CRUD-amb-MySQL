package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n02.model.dto;


import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n02.model.domain.FlorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlorDTO {

    private Integer pk_FlorID;
    private String nomFlor;
    private String paisFlor;
    private String tipusFlor;

    private static final List<String> countries = Arrays.asList("Austria", "Belgium", "Bulgaria", "Croatia", "Cyprus", "Czech Republic",
            "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy", "Latvia",
            "Lithuania", "Luxembourg", "Malta",
            "Netherlands", "Poland", "Portugal", "Romania", "Slovakia",
            "Slovenia", "Spain", "Sweden");


    public void setTipeFlor() {
        if (countries.contains(this.paisFlor)) {
            this.tipusFlor = "UE";
        } else this.tipusFlor = "Not UE";
    }

    public static FlorDTO toDTO(FlorEntity florEntity) {
        FlorDTO florDTO = FlorDTO.builder().pk_FlorID(florEntity.getPk_FlorID()).nomFlor(florEntity.getNomFlor())
                .paisFlor(florEntity.getPaisFlor()).build();
        return florDTO;
    }

}
