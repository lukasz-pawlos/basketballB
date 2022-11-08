package pl.losiek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.losiek.model.Match;
import pl.losiek.model.Player;
import pl.losiek.model.Stat;

import java.util.List;

@Repository
public interface StatRepository extends JpaRepository<Stat, Long > {
    List<Stat> findByPlayer(Player player);
    List<Stat> findByMatch(Match match);
}
