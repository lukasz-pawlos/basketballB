package pl.losiek.model;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "stats")
public class Stat {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn (name = "match_id")
    Match match;

    @OneToOne
    @JoinColumn (name = "player_id")
    Player player;

    @NonNull
    Integer points;

    @NonNull
    Integer rebounds;

    @NonNull
    Integer assists;

    @NonNull
    Integer blocks;

    @NonNull
    Integer steals;

    public Stat(Match match, Player player, Integer points, Integer rebounds, Integer assists, Integer blocks, Integer steals) {
        this.match = match;
        this.player = player;
        this.points = points;
        this.rebounds = rebounds;
        this.assists = assists;
        this.blocks = blocks;
        this.steals = steals;
    }
}
