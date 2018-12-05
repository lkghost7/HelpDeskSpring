package by.lk.controller;

import by.lk.dto.SystemUserDto;
import by.lk.entity.Branch;
import by.lk.entity.Subdivision;
import by.lk.entity.Task;
import by.lk.repository.BranchRepository;
import by.lk.repository.SubdivisionRepository;
import by.lk.services.TaskService;
import by.lk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class ExecutorController {

    private final UserService userService;
    private final BranchRepository branchRepository;
    private final SubdivisionRepository subdivisionRepository;
    private final TaskService taskService;

    @Autowired
    public ExecutorController(UserService userService, BranchRepository branchRepository, SubdivisionRepository subdivisionRepository, TaskService taskService) {
        this.userService = userService;
        this.branchRepository = branchRepository;
        this.subdivisionRepository = subdivisionRepository;
        this.taskService = taskService;
    }

    @ModelAttribute("systemUsersDto")
    public SystemUserDto systemUsersDto() {
        return new SystemUserDto();
    }

    @ModelAttribute("branches")
    public List<Branch> branch() {
        return branchRepository.findAll();
    }

    @ModelAttribute("subdivisions")
    public List<Subdivision> subdivisions() {
        return subdivisionRepository.findAll();
    }

    @ModelAttribute("executorTasks")
    public List<Task> findTaskExecutor (){
        return taskService.findExecutorTask(22L);
    }

    @GetMapping(path = "/Executor")
    public String showRegistrationForm() {
        return "Executor";
    }
}