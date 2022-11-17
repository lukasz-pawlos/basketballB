package pl.losiek.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "password")
public class Password {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String password;

    public Password(String password) {
        this.password = password;
    }
}
