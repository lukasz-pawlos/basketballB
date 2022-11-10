package pl.losiek.converter;

import pl.losiek.dto.response.NewsDTO;
import pl.losiek.model.News;

import java.util.List;
import java.util.stream.Collectors;

public class NewsConverter {

    public  static NewsDTO convertToDTO(News news) {
        return new NewsDTO(
                news.getId(),
                news.getMatch().getId(),
                news.getTitle(),
                news.getText(),
                news.getDate()
        );
    }

    public static List<NewsDTO> convertToDTOS(List<News> news) {
        return  news
                .stream()
                .map(NewsConverter::convertToDTO)
                .collect(Collectors.toList());
    }
}
