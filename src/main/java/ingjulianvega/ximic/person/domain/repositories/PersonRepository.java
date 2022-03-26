package ingjulianvega.ximic.person.domain.repositories;



import ingjulianvega.ximic.person.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonEntity, UUID>{
    List<PersonEntity> findAllByOrderByName();
}
