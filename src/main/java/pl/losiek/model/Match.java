package pl.losiek.model;

import lombok.*;
import pl.losiek.dto.response.TeamDTO;

import javax.persistence.*;

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

    public Match(Team homeTeam, Team guestTeam) {
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
    }

}
