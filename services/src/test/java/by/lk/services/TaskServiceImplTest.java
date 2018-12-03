package by.lk.services;

import by.lk.entity.Task;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TaskServiceImplTest extends CommonTest{

    @Autowired
    private TaskService taskService;

    @Test
    public void chekFindExecutorTask() {

        List<Task> findByListTask = taskService.findExecutorTask(22L);
        System.out.println(findByListTask);
    }
}
