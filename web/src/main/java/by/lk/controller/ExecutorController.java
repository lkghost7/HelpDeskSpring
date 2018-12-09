package by.lk.controller;

import by.lk.dto.SystemUserDto;
import by.lk.entity.Branch;
import by.lk.entity.Subdivision;
import by.lk.entity.SystemUser;
import by.lk.entity.Task;
import by.lk.repository.BranchRepository;
import by.lk.repository.SubdivisionRepository;
import by.lk.services.TaskService;
import by.lk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Collection;
import java.util.List;

@Controller
public class ExecutorController {

    private final UserService userService;
    private final BranchRepository branchRepository;
    private final SubdivisionRepository subdivisionRepository;
    private final TaskService taskService;

    @Autowired
    public ExecutorController(UserService userService, BranchRepository
            branchRepository, SubdivisionRepository subdivisionRepository, TaskService taskService) {
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
    public List<Task> findTaskExecutor() {
        return taskService.findExecutorTask(22L);
    }

    @ModelAttribute("systemUsers")
    public SystemUser systemUser() {
        return new SystemUser();
    }

    @GetMapping(path = "/Executor")
    public String showHelpDesk(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String systemUserEmail = user.getUsername();
        Collection<GrantedAuthority> priveleges = user.getAuthorities();
        if (priveleges.iterator().hasNext()) {
            model.addAttribute("userAuthority", priveleges.iterator().next().getAuthority().toString());
        }
        model.addAttribute("systemUsername", systemUserEmail);
        return "Executor";
    }
}