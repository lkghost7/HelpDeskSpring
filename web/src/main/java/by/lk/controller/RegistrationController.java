package by.lk.controller;

import by.lk.dto.SystemUserDto;
import by.lk.entity.Branch;
import by.lk.entity.Subdivision;
import by.lk.repository.BranchRepository;
import by.lk.repository.SubdivisionRepository;
import by.lk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RegistrationController {

    private final UserService userService;
    private final BranchRepository branchRepository;
    private final SubdivisionRepository subdivisionRepository;

    @Autowired
    public RegistrationController(UserService userService, BranchRepository branchRepository, SubdivisionRepository subdivisionRepository) {
        this.userService = userService;
        this.branchRepository = branchRepository;
        this.subdivisionRepository = subdivisionRepository;
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


    @GetMapping(path = "/registration")
    public String showRegistrationForm() {
        return "Registration";
    }

    @PostMapping(path = "/registration")
    public String tempSystemUsersDto(SystemUserDto systemUsersDto, Model model) {
        SystemUserDto systemUserDtoForDB = new SystemUserDto();
        systemUserDtoForDB.setNameUser(systemUsersDto.getNameUser());
        systemUserDtoForDB.setFamilyUser(systemUsersDto.getFamilyUser());
        systemUserDtoForDB.setEmail(systemUsersDto.getEmail());
        systemUserDtoForDB.setPasswordUser(systemUsersDto.getPasswordUser());
        systemUserDtoForDB.setPrivilegeId(2L);
        systemUserDtoForDB.setBranchId(systemUsersDto.getBranchId());
        systemUserDtoForDB.setSubdivisionId(systemUsersDto.getSubdivisionId());
        userService.saveUser(systemUserDtoForDB);
        return "/Registration";
    }
}