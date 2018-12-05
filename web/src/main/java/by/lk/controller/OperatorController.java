package by.lk.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class OperatorController {

    @GetMapping(path = "/Operator")
    public String showHelpDesk(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String systemUserEmail = user.getUsername();
        Collection<GrantedAuthority> priveleges = user.getAuthorities();
        if (priveleges.iterator().hasNext()) {
            model.addAttribute("userAuthority", priveleges.iterator().next().getAuthority().toString());
        }
        model.addAttribute("systemUsername", systemUserEmail);
        return "Operator";
    }
}