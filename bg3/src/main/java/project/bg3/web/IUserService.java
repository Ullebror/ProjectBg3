package project.bg3.web;

import project.bg3.dto.UserDto;
import project.bg3.model.AppUser;

public interface IUserService {
    AppUser registerNewUserAccount(UserDto userDto);
}