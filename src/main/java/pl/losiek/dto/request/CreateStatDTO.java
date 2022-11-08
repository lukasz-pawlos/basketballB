package pl.losiek.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class CreateStatDTO {
    Long match;
    Long player;
    Integer points;
    Integer rebounds;
    Integer assists;
    Integer blocks;
    Integer steals;
}
