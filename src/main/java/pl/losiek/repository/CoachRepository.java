package pl.losiek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.losiek.model.Coach;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {

}
