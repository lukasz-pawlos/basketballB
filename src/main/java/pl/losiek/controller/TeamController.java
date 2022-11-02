package pl.losiek.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.losiek.dto.request.CreateTeamDTO;
import pl.losiek.dto.response.TeamDTO;
import pl.losiek.service.TeamService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/teams")
public class TeamController {

    final TeamService teamService;

    @PostMapping
    public ResponseEntity<Void> createTeam(@RequestBody CreateTeamDTO request) {
        teamService.createTeam(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<TeamDTO>> getTeams() {
        return ResponseEntity.ok(teamService.getTeams());
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<TeamDTO> getTeamByID(@PathVariable Long teamId) {
        return ResponseEntity.ok(teamService.getTeam(teamId));
    }
}
