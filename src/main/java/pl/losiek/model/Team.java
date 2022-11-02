package pl.losiek.model;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;


@Getter
@Setter
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @NonNull
    String name;

    @NonNull
    String city;
}
