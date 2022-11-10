package pl.losiek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.losiek.model.News;

public interface NewsRepository extends JpaRepository<News, Long> {
}
