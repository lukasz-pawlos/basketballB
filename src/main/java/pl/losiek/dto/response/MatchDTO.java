package pl.losiek.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class MatchDTO {
    Long Id;
    Long homeTeamId;
    Long guestTeamId;
    Integer homeScore;
    Integer guestScore;
    LocalDateTime date;
}
