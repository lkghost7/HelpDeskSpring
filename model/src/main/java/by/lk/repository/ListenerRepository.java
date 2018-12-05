package by.lk.repository;

import by.lk.entity.Listener;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ListenerRepository extends CrudRepository<Listener, Long> {

    List<Listener> findAll();

}