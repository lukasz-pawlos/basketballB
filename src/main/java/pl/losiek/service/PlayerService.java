package pl.losiek.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.losiek.converter.PlayerConverter;
import pl.losiek.dto.request.CreatePlayerDTO;
import pl.losiek.dto.response.PlayerDTO;
import pl.losiek.exception.ApiException;
import pl.losiek.model.Player;
import pl.losiek.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static pl.losiek.converter.PlayerConverter.convertToDTOS;
import static pl.losiek.converter.PlayerConverter.convertToEntity;

@Service
@RequiredArgsConstructor
public class PlayerService {

    final PlayerRepository playerRepository;

    public void createPlayer(CreatePlayerDTO request) {
        if(playerRepository.existsByNumber(request.getNumber())) {
            throw new ApiException("Number of user already taken", CONFLICT);
        }

        playerRepository.save(convertToEntity(request));
    }

    public void deletePlayer(Long playerId) {
        playerRepository.deleteById(playerId);
    }

    public List<PlayerDTO> getPlayers() {
        return convertToDTOS(playerRepository.findAll(Sort.by(Sort.Direction.ASC, "Id")));
    }

    public PlayerDTO getPlayer(Long playerId) {
//        Optional<Player> player = playerRepository.findById(playerId);
//
//        if(player.isEmpty()) {
//            throw new ApiException("Player not found", NOT_FOUND);
//        }
//
//        return convertToDTO(player.get());
        return playerRepository
                .findById(playerId)
                .map(PlayerConverter::convertToDTO)
                .orElseThrow(() -> new ApiException("Player not found", NOT_FOUND));
    }

    public Player findPlayer(Long playerId) {
        return playerRepository
                .findById(playerId)
                .orElseThrow(() -> new ApiException("Player not found", NOT_FOUND));
    }
}
