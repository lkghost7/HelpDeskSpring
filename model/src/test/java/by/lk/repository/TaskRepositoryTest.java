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
    public void saveTest() {
        Set<Privilege> privileges = new HashSet<>();
        Privilege privilege = new Privilege();
        privilege.setId(1L);
        privileges.add(privilege);

        SystemUser systemUser = new SystemUser();
        systemUser.setNameUser("Тестовое Имя");
        systemUser.setFamilyUser("Тестовая фамилия");
        systemUser.setPasswordUser("какойто пароль");
        systemUser.setEmail("vvv@testMail.com");
        systemUser.setPrivilege(privileges);
        userId = systemUserRepository.save(systemUser);

        Task task = new Task();
        task.setName("Виталий");
        task.setText("Это заявка в свободной форме.");
        task.setSystemUser(systemUser);
        task.setOperator(systemUser);
        task.setExecutor(systemUser);
        task.setStatus(new Status(1L));
        taskId = taskRepository.save(task);

        Task myTask = taskRepository.findOne(taskId.getId());
        Assert.assertEquals(taskId.getId(), myTask.getId());
        systemUserRepository.delete(userId);
    }

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
    }

    @After
    public void finish() {
        taskRepository.delete(taskId);
        final Task one = taskRepository.findOne(taskId.getId());
        assertNull(one);
    }
}