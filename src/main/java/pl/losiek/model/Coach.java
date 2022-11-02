package pl.losiek.model;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "coaches")
public class Coach {

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
    String role;

    @NonNull
    Integer age;
}
