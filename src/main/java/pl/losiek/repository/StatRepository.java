package pl.losiek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.losiek.model.Match;
import pl.losiek.model.Stat;

import java.util.List;

@Repository
public interface StatRepository extends JpaRepository<Stat, Long > {
    List<Stat> findByPlayerId(Long player);
    @Query("SELECT s FROM Stat s WHERE s.match.id = ?1")
    List<Stat> findByMatch(Long match);
}
