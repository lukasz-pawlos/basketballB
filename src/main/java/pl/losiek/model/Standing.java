package pl.losiek.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Standing {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn (name = "team_id")
    Team team;

    Integer win;

    Integer lose;

    @Formula("2*win + lose")
    Integer points;

    public void updateWin() {
        this.win += 1;
    }

    public void updateLose() {
        this.lose += 1;
    }

    public Standing(Team team) {
        this.team = team;
        this.win = 0;
        this.lose = 0;
    }
}
