package hr.tvz.bekavac.hardwareapp.service;

import hr.tvz.bekavac.hardwareapp.command.LoginCommand;
import hr.tvz.bekavac.hardwareapp.domain.User;
import hr.tvz.bekavac.hardwareapp.dto.LoginDTO;
import hr.tvz.bekavac.hardwareapp.repository.UserRepository;
import hr.tvz.bekavac.hardwareapp.service.interfaces.AuthenticationService;
import hr.tvz.bekavac.hardwareapp.service.interfaces.JwtService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    public AuthenticationServiceImpl(JwtService jwtService, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<LoginDTO> login(LoginCommand command) {
        Optional<User> user = userRepository.findByUsername(command.getUsername());

        if (user.isEmpty() || !isMatchingPassword(command.getPassword(), user.get().getPassword())) {
            return Optional.empty();
        }

        return Optional.of(
                new LoginDTO(jwtService.createJwt(user.get()))
        );
    }

    private boolean isMatchingPassword(String rawPassword, String encryptedPassword) {
        // TODO - implementirati provjeru odgovara li lozinka, koju je unio korisnik, enkriptiranoj lozinki u bazi
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(passwordEncoder.matches(rawPassword, encryptedPassword)){
            return true;
        }
        throw new UnsupportedOperationException();
    }
}
