package by.lk.controller;

import by.lk.entity.Branch;
import by.lk.entity.SystemUser;
import by.lk.repository.BranchRepository;
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
public class RegisterBranchController {

    private final UserService userService;
    private final BranchRepository branchRepository;

    @Autowired
    public RegisterBranchController(UserService userService, BranchRepository
            branchRepository) {
        this.userService = userService;
        this.branchRepository = branchRepository;
    }

    @ModelAttribute("branches")
    public List<Branch> branch() {
        return branchRepository.findAll();
    }


    @ModelAttribute("systemUsers")
    public SystemUser systemUser() {
        return new SystemUser();
    }

    @GetMapping(path = "/registerBranch")
    public String showHelpDesk(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String systemUserEmail = user.getUsername();
        Collection<GrantedAuthority> priveleges = user.getAuthorities();
        if (priveleges.iterator().hasNext()) {
            model.addAttribute("userAuthority", priveleges.iterator().next().getAuthority().toString());
        }
        model.addAttribute("systemUsername", systemUserEmail);
        return "registerBranch";
    }
}