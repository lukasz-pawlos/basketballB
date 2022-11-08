package pl.losiek.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.losiek.dto.request.CreateTeamDTO;
import pl.losiek.dto.response.TeamDTO;
import pl.losiek.exception.ApiException;
import pl.losiek.model.Team;
import pl.losiek.repository.TeamRepository;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static pl.losiek.converter.TeamConverter.*;

@Service
@RequiredArgsConstructor
public class TeamService {

    final TeamRepository teamRepository;
    final StandingService standingService;

    public void createTeam(CreateTeamDTO request) {
        Team team = teamRepository.save(convertToEntity(request));
        standingService.createStanding(team);
    }

    public List<TeamDTO> getTeams() {
        return convertTODTOS(teamRepository.findAll());
    }

    public TeamDTO getTeam(Long teamId){
        return convertToDTO(findTeam(teamId));
    }

    public Team findTeam(Long teamId){
        return teamRepository
                .findById(teamId)
                .orElseThrow(() -> new ApiException("Team not found", NOT_FOUND));
    }
}
