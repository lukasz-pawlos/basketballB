package pl.losiek.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class NewsDTO {
    Long Id;
    Long matchId;
    String title;
    String text;
    LocalDateTime date;
}
