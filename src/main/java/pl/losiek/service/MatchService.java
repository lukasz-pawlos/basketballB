package pl.losiek.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.losiek.dto.other.ScoreDTO;
import pl.losiek.dto.request.CreateMatchDTO;
import pl.losiek.exception.ApiException;
import pl.losiek.model.Match;
import pl.losiek.repository.MatchRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class MatchService {

    final MatchRepository matchRepository;
    final TeamService teamService;

    public void createMatch(CreateMatchDTO request) {
        Match match = new Match(
                teamService.findTeam(request.getHomeTeamId()),
                teamService.findTeam(request.getGuestTeamId()),
                request.getDate()
        );
        matchRepository.save(match);
    }

    public List<Match> getMatches() {
        return matchRepository.findAll(Sort.by(Sort.Direction.ASC, "Id"));
    }

    public Match getMatch(Long matchId) {
        Optional<Match> match = matchRepository.findById(matchId);

        return match.orElseThrow(() -> new ApiException("Match not found", NOT_FOUND));
    }

    public void updateScore(Long matchId, ScoreDTO score) {
        Match match = getMatch(matchId);

        match.setHomeScore(score.getHomeScore());
        match.setGuestScore(score.getGuestScore());

        matchRepository.save(match);
    }
}
