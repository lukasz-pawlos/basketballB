package pl.losiek.dto.other;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ScoreDTO {
    Integer homeScore;
    Integer guestScore;
}
