package pl.losiek.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class CreateNewsDTO {
    Long matchId;
    String title;
    String text;
}
