package by.lk.services;

import by.lk.dto.SystemUserDto;
import by.lk.entity.SystemUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    Long saveUser(SystemUserDto systemUserDto);

    SystemUser findByEmail(String name);

    List<SystemUser> findAll();

    SystemUser findById(Long id);

}