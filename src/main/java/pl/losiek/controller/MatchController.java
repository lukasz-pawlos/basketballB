package pl.losiek.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.losiek.dto.request.CreateMatchDTO;
import pl.losiek.dto.response.PlayerDTO;
import pl.losiek.model.Match;
import pl.losiek.service.MatchService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/matches")
public class MatchController {

    final MatchService matchService;

    @PostMapping
    public ResponseEntity<Void> createMatch(@RequestBody CreateMatchDTO request) {
        matchService.createMatch(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Match>> getMatches() {
        return ResponseEntity.ok(matchService.getMatches());
    }

    @GetMapping("/{matchId}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long matchId) {
        return ResponseEntity.ok(matchService.getMatch(matchId));
    }
}
