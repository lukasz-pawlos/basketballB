package pl.losiek.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.losiek.converter.PlayerConverter;
import pl.losiek.converter.StandingConverter;
import pl.losiek.dto.response.StandingDTO;
import pl.losiek.exception.ApiException;
import pl.losiek.model.Standing;
import pl.losiek.model.Team;
import pl.losiek.repository.StandingRepository;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static pl.losiek.converter.StandingConverter.convertToDTO;
import static pl.losiek.converter.StandingConverter.convertToDTOS;

@Service
@RequiredArgsConstructor
public class StandingService {
    final StandingRepository standingRepository;

    public void createStanding(Team team) {
        Standing standing = new Standing(team);
        standingRepository.save(standing);
    }

// To rób debilu
    public StandingDTO getStanding(Long teamId) {
        return convertToDTO(findStanding(teamId));
    }

    public List<StandingDTO> getStandings() {
        return convertToDTOS(standingRepository.findAll(Sort.by(Sort.Direction.DESC, "Points")));
    }

    public Standing findStanding(Long teamId) {
        return standingRepository.findByTeamId(teamId)
                .orElseThrow(() -> new ApiException("Standing not found", NOT_FOUND));
    }

    public void updateWin(Long teamId) {
        Standing standing = findStanding(teamId);
        standing.updateWin();
        standingRepository.save(standing);
    }

    public void updateLose(Long teamId) {
        Standing standing = findStanding(teamId);
        standing.updateLose();
        standingRepository.save(standing);
    }
}
