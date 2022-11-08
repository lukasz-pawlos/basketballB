package pl.losiek.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.losiek.dto.request.CreateStatDTO;
import pl.losiek.exception.ApiException;
import pl.losiek.model.Stat;
import pl.losiek.repository.StatRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class StatService {

    final StatRepository statRepository;
    final PlayerService playerService;
    final MatchService matchService;

    public void createStat(CreateStatDTO request) {
        Stat stat = new Stat(
                matchService.getMatch(request.getMatch()),
                playerService.findPlayer(request.getPlayer()),
                request.getPoints(),
                request.getRebounds(),
                request.getAssists(),
                request.getBlocks(),
                request.getSteals()
        );
        statRepository.save(stat);
    }

    public List<Stat> getStatsByPlayerId(Long playerId) {
        return statRepository.findByPlayer(playerService.findPlayer(playerId));
    }

    public List<Stat> getStatsByMatchId(Long matchId) {
        return statRepository.findByMatch(matchService.getMatch(matchId));
    }
}
