package pl.losiek.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class CreatePlayerDTO {
    String name;
    String secondName;
    String nationality;
    Integer number;
    Integer age;
}
