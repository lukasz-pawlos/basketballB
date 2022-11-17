package pl.losiek.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.losiek.exception.ApiException;
import pl.losiek.model.Password;
import pl.losiek.repository.PasswordRepository;

import static org.springframework.http.HttpStatus.*;


@Service
@RequiredArgsConstructor
public class PasswordService {

    final PasswordRepository passwordRepository;

    public void createPassword(String password) {
        Password passwordObj = new Password(password);
        passwordRepository.save(passwordObj);
    }

    public Password getPassword(Long passwordId) {
        return passwordRepository.findById(passwordId)
                .orElseThrow(() -> new ApiException("Password not found", NOT_FOUND));
    }

}
