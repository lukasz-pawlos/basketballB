package pl.losiek.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.losiek.dto.other.AvgStatDTO;
import pl.losiek.dto.request.CreateStatDTO;
import pl.losiek.model.Stat;
import pl.losiek.repository.StatRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

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
        return statRepository.findByPlayerId(playerId);
    }

    public List<Stat> getStatsByMatchId(Long matchId) {
        return statRepository.findByMatch(matchId);
    }

    public List<AvgStatDTO> getAvgStats() {
        return statRepository.findAvgStats().stream().map(dto -> {
            dto.setAssists(BigDecimal.valueOf(dto.getAssists()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            dto.setPoints(BigDecimal.valueOf(dto.getPoints()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            dto.setRebounds(BigDecimal.valueOf(dto.getRebounds()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            dto.setBlocks(BigDecimal.valueOf(dto.getBlocks()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            dto.setSteals(BigDecimal.valueOf(dto.getSteals()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            return dto;
        }).toList();
    }

    public AvgStatDTO getAvgStat(Long playerId) {
        AvgStatDTO dto = statRepository.findAvgStats(playerId);
            dto.setAssists(BigDecimal.valueOf(dto.getAssists()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            dto.setPoints(BigDecimal.valueOf(dto.getPoints()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            dto.setRebounds(BigDecimal.valueOf(dto.getRebounds()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            dto.setBlocks(BigDecimal.valueOf(dto.getBlocks()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            dto.setSteals(BigDecimal.valueOf(dto.getSteals()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            return dto;
    }
}
