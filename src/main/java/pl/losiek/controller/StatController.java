package pl.losiek.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.losiek.dto.other.AvgStatDTO;
import pl.losiek.dto.request.CreateStatDTO;
import pl.losiek.model.Stat;
import pl.losiek.service.StatService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/stats")
public class StatController {

    final StatService statService;

    @PostMapping
    public ResponseEntity<Void> createStat(@RequestBody CreateStatDTO request) {
        statService.createStat(request);
        return  ResponseEntity.ok().build();
    }

    @GetMapping("/player/{playerId}")
    public ResponseEntity<List<Stat>> getStatsByPlayerId(@PathVariable Long playerId) {
        return ResponseEntity.ok(statService.getStatsByPlayerId(playerId));
    }

    @GetMapping("/match/{matchId}")
    public ResponseEntity<List<Stat>> getStatsByMatchId(@PathVariable Long matchId) {
        return ResponseEntity.ok(statService.getStatsByMatchId(matchId));
    }

    @GetMapping("/avg")
    public ResponseEntity<List<AvgStatDTO>> getAvgStats() {
        return ResponseEntity.ok(statService.getAvgStats());
    }

    @GetMapping("/avg/{playerId}")
    public ResponseEntity<AvgStatDTO> getAvgStats(@PathVariable Long playerId) {
        return ResponseEntity.ok(statService.getAvgStat(playerId));
    }
}
