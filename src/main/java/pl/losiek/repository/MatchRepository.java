package pl.losiek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.losiek.model.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

}
