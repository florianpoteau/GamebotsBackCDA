package co.simplon.gamebotsback.business.service.user;

import co.simplon.gamebotsback.business.dto.UserDTO;

public interface IUserService {

    UserDTO findByUsername(String username);

}
