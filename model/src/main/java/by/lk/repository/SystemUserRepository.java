package by.lk.repository;

import by.lk.entity.SystemUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SystemUserRepository extends CrudRepository<SystemUser, Long> {

    SystemUser findByEmail(String email);

    List<SystemUser> findAll();

    SystemUser findOne(Long id);
}