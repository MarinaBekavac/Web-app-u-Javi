package hr.tvz.bekavac.hardwareapp.service.interfaces;

import hr.tvz.bekavac.hardwareapp.command.LoginCommand;
import hr.tvz.bekavac.hardwareapp.dto.LoginDTO;

import java.util.Optional;

public interface AuthenticationService {

    Optional<LoginDTO> login(LoginCommand command);

}
