package co.simplon.gamebotsback.business.service.user;

import co.simplon.gamebotsback.business.dto.UserDTO;

public interface IUserService {

    void createAccount(final UserDTO user);

    UserDTO getById(final int id);

    UserDTO modifyAccount(int id, UserDTO user);

    void deleteAccount(int id);

}
