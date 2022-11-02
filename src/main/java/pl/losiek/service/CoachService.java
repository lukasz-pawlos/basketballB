package pl.losiek.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.losiek.converter.CoachConverter;
import pl.losiek.dto.request.CreateCoachDTO;
import pl.losiek.dto.response.CoachDTO;
import pl.losiek.exception.ApiException;
import pl.losiek.repository.CoachRepository;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static pl.losiek.converter.CoachConverter.convertToDTOS;
import static pl.losiek.converter.CoachConverter.convertToEntity;

@Service
@RequiredArgsConstructor
public class CoachService {

    final CoachRepository coachRepository;

    public void createCoach(CreateCoachDTO request) {
        coachRepository.save(convertToEntity(request));
    }

    public List<CoachDTO> getCoaches() {
        return convertToDTOS(coachRepository.findAll());
    }

    public CoachDTO getCoach(Long coachId) {
        return coachRepository
                .findById(coachId)
                .map(CoachConverter::convertToDTO)
                .orElseThrow(() -> new ApiException("Coach not found", NOT_FOUND));
    }
}
