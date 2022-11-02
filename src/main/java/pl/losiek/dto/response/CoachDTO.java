package pl.losiek.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CoachDTO {
    Long id;
    String name;
    String secondName;
    String nationality;
    String role;
    Integer age;
}
