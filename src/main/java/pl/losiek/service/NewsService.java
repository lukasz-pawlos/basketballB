package pl.losiek.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.losiek.converter.NewsConverter;
import pl.losiek.dto.request.CreateNewsDTO;
import pl.losiek.dto.response.NewsDTO;
import pl.losiek.exception.ApiException;
import pl.losiek.model.News;
import pl.losiek.repository.NewsRepository;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static pl.losiek.converter.NewsConverter.convertToDTO;
import static pl.losiek.converter.NewsConverter.convertToDTOS;

@Service
@RequiredArgsConstructor
public class NewsService {

    final NewsRepository newsRepository;
    final MatchService matchService;

    public void createNews(CreateNewsDTO request) {
        News news = new News(
                matchService.getMatch(request.getMatchId()),
                request.getTitle(),
                request.getText()
        );
        newsRepository.save(news);
    }

    public List<NewsDTO> getNews() {
        return convertToDTOS(newsRepository.findAll());
    }

    public NewsDTO getNewsById(Long newsId) {
        return newsRepository
                .findById(newsId)
                .map(NewsConverter::convertToDTO)
                .orElseThrow(() -> new ApiException("News not found", NOT_FOUND));

    }
}
