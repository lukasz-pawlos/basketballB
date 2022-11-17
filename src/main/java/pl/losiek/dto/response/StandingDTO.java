package pl.losiek.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.losiek.model.Team;

@AllArgsConstructor
@Getter
@Setter
public class StandingDTO {
    Long id;
    Team team;
    Integer win;
    Integer lose;
    Integer points;
}
