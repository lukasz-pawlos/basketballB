package pl.losiek.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StandingDTO {
    Long id;
    Long teamId;
    Integer win;
    Integer lose;
    Integer points;
}
