package pl.losiek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.losiek.model.News;
import pl.losiek.model.Password;

public interface PasswordRepository extends JpaRepository<Password, Long> {
}
