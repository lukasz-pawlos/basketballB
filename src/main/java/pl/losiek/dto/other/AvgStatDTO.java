package pl.losiek.dto.other;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class AvgStatDTO {
    Long playerId;
    Double points;
    Double rebounds;
    Double assists;
    Double blocks;
    Double steals;


}

