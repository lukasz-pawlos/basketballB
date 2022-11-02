package pl.losiek.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.losiek.dto.request.CreateCoachDTO;
import pl.losiek.dto.response.CoachDTO;
import pl.losiek.service.CoachService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/coaches")
public class CoachController {

    final CoachService coachService;

    @PostMapping
    public ResponseEntity<Void> createCoach(@RequestBody CreateCoachDTO request) {
        coachService.createCoach(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<CoachDTO>> getCoaches() {
        return ResponseEntity.ok(coachService.getCoaches());
    }

    @GetMapping("/{coachId}")
    public ResponseEntity<CoachDTO> getCoachById(@PathVariable Long coachId) {
        return ResponseEntity.ok(coachService.getCoach(coachId));
    }
}
