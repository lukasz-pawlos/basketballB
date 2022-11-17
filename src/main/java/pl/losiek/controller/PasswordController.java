package pl.losiek.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.losiek.dto.request.CreatePlayerDTO;
import pl.losiek.dto.response.PlayerDTO;
import pl.losiek.exception.ApiException;
import pl.losiek.model.Password;
import pl.losiek.service.PasswordService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/password")
public class PasswordController {

    final PasswordService passwordService;

    @PostMapping
    public ResponseEntity<Void> createPlayer(@RequestBody String request) {
        passwordService.createPassword(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> checkPassword(@RequestBody String request) {
        Password passwordDB = passwordService.getPassword(1L);
        if (passwordDB.getPassword().equals(request)){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(408).build();        }
    }
}
