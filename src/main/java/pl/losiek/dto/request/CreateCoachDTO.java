package pl.losiek.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateCoachDTO {
    String name;
    String secondName;
    String nationality;
    String role;
    Integer age;
}