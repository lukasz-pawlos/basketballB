package pl.losiek.converter;

import pl.losiek.dto.response.StandingDTO;
import pl.losiek.model.Standing;

import java.util.List;
import java.util.stream.Collectors;

public class StandingConverter {

    public static StandingDTO convertToDTO(Standing standing) {
        return new StandingDTO(
                standing.getId(),
                standing.getTeam(),
                standing.getWin(),
                standing.getLose(),
                standing.getPoints()
        );
    }

    public static List<StandingDTO> convertToDTOS(List<Standing> standings) {
        return standings
                .stream()
                .map(StandingConverter::convertToDTO)
                .collect(Collectors.toList());
    }
}
