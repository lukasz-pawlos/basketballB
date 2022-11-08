package pl.losiek.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.losiek.dto.response.StandingDTO;
import pl.losiek.service.StandingService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/standings")
public class StandingController {

    final StandingService standingService;

    @GetMapping
    public ResponseEntity<List<StandingDTO>> getStandings() {
        return ResponseEntity.ok(standingService.getStandings());
    }

    @PatchMapping("/{teamId}/win")
    public ResponseEntity<Void> updateWin(@PathVariable Long teamId) {
        standingService.updateWin(teamId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{teamId}/lose")
    public ResponseEntity<Void> updateLose(@PathVariable Long teamId) {
        standingService.updateLose(teamId);
        return ResponseEntity.ok().build();
    }
}
