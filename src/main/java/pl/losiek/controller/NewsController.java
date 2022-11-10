package pl.losiek.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.losiek.dto.request.CreateNewsDTO;
import pl.losiek.dto.response.NewsDTO;
import pl.losiek.service.NewsService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/news")
public class NewsController {

    final NewsService newsService;

    @PostMapping
    public ResponseEntity<Void> createNews(@RequestBody CreateNewsDTO request) {
        newsService.createNews(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<NewsDTO>> getNews() {
        return ResponseEntity.ok(newsService.getNews());
    }

    @GetMapping("/{newsId}")
    public ResponseEntity<NewsDTO> getNewsById(@PathVariable Long newsId) {
        return ResponseEntity.ok(newsService.getNewsById(newsId));
    }
}
