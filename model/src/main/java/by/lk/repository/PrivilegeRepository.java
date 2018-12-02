package by.lk.repository;

import by.lk.entity.Privilege;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

    List<Privilege> findAll();
}