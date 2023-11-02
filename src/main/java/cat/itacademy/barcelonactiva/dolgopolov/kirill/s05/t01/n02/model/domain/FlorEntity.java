package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n02.model.domain;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n02.model.dto.FlorDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlorEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk_FlorID;

    private String nomFlor;

    private String paisFlor;

    public static FlorEntity toEntity(FlorDTO florDTO) {
        FlorEntity florEntity = FlorEntity.builder().pk_FlorID(florDTO.getPk_FlorID()).nomFlor(florDTO.getNomFlor())
                .paisFlor(florDTO.getPaisFlor()).build();
        return florEntity;
    }
}
