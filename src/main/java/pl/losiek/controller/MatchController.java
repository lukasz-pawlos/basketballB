package pl.losiek.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.losiek.dto.other.ScoreDTO;
import pl.losiek.dto.request.CreateMatchDTO;
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

    @PatchMapping("/{matchId}")
    public ResponseEntity<Void> updateScore(@PathVariable Long matchId, @RequestBody ScoreDTO request) {
        matchService.updateScore(matchId, request);
        return  ResponseEntity.ok().build();
    }
}
