package pl.losiek.model;

import lombok.*;
import pl.losiek.dto.response.TeamDTO;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn (name = "home_team_id")
    Team homeTeam;

    @OneToOne
    @JoinColumn (name = "guest_team_id")
    Team guestTeam;

    Integer homeScore;

    Integer guestScore;

    LocalDateTime date;

    public Match(Team homeTeam, Team guestTeam, LocalDateTime date) {
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.date = date;
    }

}
