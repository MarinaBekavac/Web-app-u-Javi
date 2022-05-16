package hr.tvz.bekavac.hardwareapp.service.interfaces;

import hr.tvz.bekavac.hardwareapp.domain.User;

public interface JwtService {

    boolean authenticate(String token);

    String createJwt(User user);

}
