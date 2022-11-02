package pl.losiek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.losiek.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query("SELECT COUNT(p) > 0 " +
            "FROM Player p " +
            "WHERE p.number = ?1")
    boolean existsByNumber(Integer number);
}
