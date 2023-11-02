package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n02.model.repository;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n02.model.domain.FlorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlorRepository extends JpaRepository<FlorEntity, Integer> {
}
