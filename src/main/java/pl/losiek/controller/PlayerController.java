package pl.losiek.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.losiek.dto.request.CreatePlayerDTO;
import pl.losiek.dto.response.PlayerDTO;
import pl.losiek.service.PlayerService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/players")
public class PlayerController {

    final PlayerService playerService;

    @PostMapping
    public ResponseEntity<Void> createPlayer(@RequestBody CreatePlayerDTO request) {
        playerService.createPlayer(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> getPlayers() {
        return ResponseEntity.ok(playerService.getPlayers());
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable Long playerId) {
        return ResponseEntity.ok(playerService.getPlayer(playerId));
    }
}
