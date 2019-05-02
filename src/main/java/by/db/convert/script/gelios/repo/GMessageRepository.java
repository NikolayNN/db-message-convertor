package by.db.convert.script.gelios.repo;

import by.db.convert.script.gelios.domain.GMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GMessageRepository extends JpaRepository<GMessage, Long> {

  List<GMessage> findAllByUnitId(String unitId);
}
