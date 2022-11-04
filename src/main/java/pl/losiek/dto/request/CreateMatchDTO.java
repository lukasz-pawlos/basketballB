package pl.losiek.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.losiek.dto.response.TeamDTO;

@AllArgsConstructor
@Setter
@Getter
public class CreateMatchDTO {
    Long homeTeamId;
    Long guestTeamId;
}
