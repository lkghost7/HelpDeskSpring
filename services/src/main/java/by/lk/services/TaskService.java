package by.lk.services;

import by.lk.dto.TaskDto;
import by.lk.entity.Task;

import java.util.List;

public interface TaskService {

    Long saveTask(TaskDto taskDto);

    List<TaskDto> findAll();

    Task findById(Long id);

    List<TaskDto> findBySystemUserId(Long id);

    void delete(Long id);

    List<Task> findExecutorTask (Long executorId);
}