package pl.losiek.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class TeamDTO {
    Long id;
    String name;
    String city;
}
