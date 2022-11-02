package pl.losiek.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PlayerDTO {
    Long id;
    String name;
    String secondName;
    String nationality;
    Integer number;
    Integer age;
}
