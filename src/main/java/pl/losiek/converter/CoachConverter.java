package pl.losiek.converter;

import pl.losiek.dto.request.CreateCoachDTO;
import pl.losiek.dto.response.CoachDTO;
import pl.losiek.model.Coach;

import java.util.List;
import java.util.stream.Collectors;

public class CoachConverter {

    public static Coach convertToEntity(CreateCoachDTO request) {
        return new Coach(
                request.getName(),
                request.getSecondName(),
                request.getNationality(),
                request.getRole(),
                request.getAge()
        );
    }

    public static CoachDTO convertToDTO(Coach coach) {
        return new CoachDTO(
                coach.getId(),
                coach.getName(),
                coach.getSecondName(),
                coach.getNationality(),
                coach.getRole(),
                coach.getAge()
        );
    }

    public static List<CoachDTO> convertToDTOS(List<Coach> coaches) {
        return coaches
                .stream()
                .map(CoachConverter::convertToDTO)
                .collect(Collectors.toList());
    }
}
