package pl.losiek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.losiek.dto.other.AvgStatDTO;
import pl.losiek.model.Match;
import pl.losiek.model.Stat;

import java.util.List;

@Repository
public interface StatRepository extends JpaRepository<Stat, Long > {
    List<Stat> findByPlayerId(Long player);
    @Query("SELECT s FROM Stat s WHERE s.match.id = ?1")
    List<Stat> findByMatch(Long match);

    @Query("SELECT new pl.losiek.dto.other.AvgStatDTO(s.player.id, AVG(s.points), AVG(s.rebounds), AVG(s.assists), AVG(s.blocks), AVG(s.steals)) " +
            "FROM Stat s GROUP BY s.player.id")
    List<AvgStatDTO> findAvgStats();

    @Query("SELECT new pl.losiek.dto.other.AvgStatDTO(s.player.id, AVG(s.points), AVG(s.rebounds), AVG(s.assists), AVG(s.blocks), AVG(s.steals)) " +
            "FROM Stat s WHERE s.player.id = ?1 GROUP BY s.player.id")
    AvgStatDTO findAvgStats(Long playerId);
}
