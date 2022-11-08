package pl.losiek.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StatDTO {
    Long Id;
    Long match;
    Long player;
    Integer points;
    Integer rebounds;
    Integer assists;
    Integer blocks;
    Integer steals;
}
