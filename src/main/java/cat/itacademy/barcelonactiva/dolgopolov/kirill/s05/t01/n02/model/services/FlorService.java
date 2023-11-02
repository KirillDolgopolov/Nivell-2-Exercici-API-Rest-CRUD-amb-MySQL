package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n02.model.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlorService {
    @Autowired
    FlorRepository florRepository;

    public FlorDTO updateByID(Integer id, FlorDTO florDTO) {
        Optional<FlorEntity> entity = florRepository.findById(id);
        if (entity.isPresent()) {
            FlorEntity florEntity = entity.get();
            florEntity.setNomFlor(florDTO.getNomFlor());
            florEntity.setPaisFlor(florDTO.getPaisFlor());
            florRepository.save(florEntity);
            return FlorDTO.toDTO(florEntity);

        } else return null;
    }


        public ArrayList<FlorDTO> getAll () {
            List<FlorEntity> flors = florRepository.findAll();
            ArrayList<FlorDTO> florsDTO = new ArrayList<>();
            flors.forEach(s -> florsDTO.add(FlorDTO.toDTO(s)));
            florsDTO.forEach(s -> s.setTipeFlor());
            return florsDTO;
        }

        public FlorEntity saveFlor (FlorDTO florDTO){
            FlorEntity flor = FlorEntity.toEntity(florDTO);
            return florRepository.save(flor);
        }

        public Optional<FlorDTO> getByID (Integer id){
            FlorDTO florDTO = FlorDTO.toDTO(florRepository.getReferenceById(id));
            florDTO.setTipeFlor();
            return Optional.ofNullable(florDTO);
        }

        public boolean deleteByID (Integer id){
            try {
                florRepository.deleteById(id);
                return true;
            } catch (Exception e) {
                return false;
            }


        }

}