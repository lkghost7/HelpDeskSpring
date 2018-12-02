package by.lk.services;

import by.lk.dto.TaskDto;
import by.lk.repository.TaskRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class TaskServiceTest extends CommonTest {
    private Long id;
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void saveTaskTest() {
        TaskDto taskDto = new TaskDto();
        taskDto.setName("Подсоединить картридж");
        taskDto.setText("Закончился старый картридж. Надо замена.");
        id = taskService.saveTask(taskDto);
        taskRepository.delete(id);
    }

    @Test
    public void findAllTest() {
    }
}