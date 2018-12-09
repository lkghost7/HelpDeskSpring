package by.lk.repository;

import by.lk.entity.Privilege;
import by.lk.entity.Status;
import by.lk.entity.SystemUser;
import by.lk.entity.Task;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNull;

public class TaskRepositoryTest extends CommonTest {
    private Task taskId;
    private SystemUser userId;

    @Autowired
    private SystemUserRepository systemUserRepository;
    @Autowired
    private TaskRepository taskRepository;



    @Test
    public void findByNameTest() {
        String name = "Виталий";
        Task task = new Task();
        task.setName(name);
        task.setText("Это заявка в свободной форме 2.");
        task.setStatus(new Status(1L));

        taskId = taskRepository.save(task);

        List<Task> actual = Arrays.asList(task);
        List<Task> expected = taskRepository.findByName(name);
        Assert.assertEquals(actual.get(0).getName(), expected.get(0).getName());
        taskRepository.delete(taskId);
    }

    @Test
    public void findByExecutorIdTest() {
        List<Task> taskList = taskRepository.findAllByExecutorEquals(systemUserRepository.findOne(22L));
        Assert.assertNotNull(taskList);
    }
}