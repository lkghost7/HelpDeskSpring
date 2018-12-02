package by.lk.repository;

import by.lk.entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

    Task findOne(Long id);

    List<Task> findByName(String name);

    List<Task> findAllBySystemUserId(Long id);
}