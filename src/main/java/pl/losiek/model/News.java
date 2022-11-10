package pl.losiek.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn (name = "matchId")
    Match match;

    @NonNull
    String title;

    @NonNull
    String text;

    @NonNull
    LocalDateTime date;

    public News(Match match, String title, String text) {
        this.match = match;
        this.title = title;
        this.text = text;
        this.date = LocalDateTime.now();
    }
}
