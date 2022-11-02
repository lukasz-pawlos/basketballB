package pl.losiek.model;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @NonNull
    String name;

    @NonNull
    String secondName;

    @NonNull
    String nationality;

    @NonNull
    @Column(unique = true)
    Integer number;

    @NonNull
    Integer age;
}
