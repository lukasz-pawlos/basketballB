package pl.losiek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.losiek.model.Standing;

import java.util.Optional;

public interface StandingRepository extends JpaRepository<Standing, Long> {

    @Query("SELECT s FROM Standing s WHERE s.team.id = ?1")
    Optional<Standing> findByTeamId(Long teamId);
}
