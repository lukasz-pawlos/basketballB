package pl.losiek.converter;

import pl.losiek.dto.request.CreatePlayerDTO;
import pl.losiek.dto.response.PlayerDTO;
import pl.losiek.model.Player;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class PlayerConverter {

    public static Player convertToEntity(CreatePlayerDTO request) {
        return new Player(
                request.getName(),
                request.getSecondName(),
                request.getNationality(),
                request.getNumber(),
                request.getAge()
        );
    }

    public static PlayerDTO convertToDTO(Player player) {
        return new PlayerDTO(
                player.getId(),
                player.getName(),
                player.getSecondName(),
                player.getNationality(),
                player.getNumber(),
                player.getAge()
        );
    }

    public static List<PlayerDTO> convertToDTOS(List<Player> players) {
        return players
                .stream()
                .map(PlayerConverter::convertToDTO)
                .collect(toList());
    }
}
