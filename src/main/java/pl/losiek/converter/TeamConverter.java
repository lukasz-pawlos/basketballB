package pl.losiek.converter;

import pl.losiek.dto.request.CreateTeamDTO;
import pl.losiek.dto.response.TeamDTO;
import pl.losiek.model.Team;

import java.util.List;
import java.util.stream.Collectors;

public class TeamConverter {

    public static Team convertTOEntity(CreateTeamDTO request) {
        return new Team(
                request.getName(),
                request.getCity()
        );
    }

    public static TeamDTO convertTODTO(Team team) {
        return new TeamDTO(
                team.getId(),
                team.getName(),
                team.getCity()
        );
    }

    public static List<TeamDTO> convertTODTOS(List<Team> teams) {
        return teams
                .stream()
                .map(TeamConverter::convertTODTO)
                .collect(Collectors.toList());
    }
}
