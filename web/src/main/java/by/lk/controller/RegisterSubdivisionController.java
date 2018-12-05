package by.lk.controller;

import by.lk.entity.Subdivision;
import by.lk.entity.SystemUser;
import by.lk.repository.SubdivisionRepository;
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
public class RegisterSubdivisionController {

    private final UserService userService;
    private final SubdivisionRepository subdivisionRepository;

    @Autowired
    public RegisterSubdivisionController(UserService userService, SubdivisionRepository subdivisionRepository) {
        this.userService = userService;
        this.subdivisionRepository = subdivisionRepository;
    }

    @ModelAttribute("subdivisions")
    public List<Subdivision> subdivisions() {
        return subdivisionRepository.findAll();
    }

    @ModelAttribute("systemUsers")
    public SystemUser systemUser() {
        return new SystemUser();
    }

    @GetMapping(path = "/registerSubdivision")
    public String showHelpDesk(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String systemUserEmail = user.getUsername();
        Collection<GrantedAuthority> priveleges = user.getAuthorities();
        if (priveleges.iterator().hasNext()) {
            model.addAttribute("userAuthority", priveleges.iterator().next().getAuthority().toString());
        }
        model.addAttribute("systemUsername", systemUserEmail);
        return "registerSubdivision";
    }
}