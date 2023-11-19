package project.bg3.service;

import project.bg3.dto.UserDto;
import project.bg3.entity.AppUser;

public interface IUserService {
    AppUser registerNewUserAccount(UserDto userDto);
}