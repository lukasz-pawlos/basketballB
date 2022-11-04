package pl.losiek.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MatchDTO {
    Long Id;
    Long homeTeamId;
    Long guestTeamId;
    Integer homeScore;
    Integer guestScore;
}
