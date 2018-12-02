package by.lk.services;

import by.lk.dto.SystemUserDto;
import by.lk.entity.SystemUser;
import by.lk.repository.SystemUserRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import static org.junit.Assert.assertNull;

public class UserServiceTest extends CommonTest {
    private Long id;
    @Autowired
    private UserService userService;
    @Autowired
    private SystemUserRepository systemUserRepository;

    @Test
    public void saveUserTest() {
        SystemUserDto systemUserDto = new SystemUserDto();
        systemUserDto.setNameUser("Виталий");
        systemUserDto.setFamilyUser("Ушаков");
        systemUserDto.setEmail("v");
        systemUserDto.setPasswordUser("1");
        systemUserDto.setPrivilegeId(1L);
        systemUserDto.setBranchId(1L);
        systemUserDto.setSubdivisionId(1L);
        id = userService.saveUser(systemUserDto);
        SystemUser userId = userService.findById(id);
        Assert.assertEquals("Сохранение пользователя в БД через Dto: ", id, userId.getId());
    }

    @Test
    @Rollback
    public void findByEmailTest() {
        Long id2;
        SystemUserDto systemUserDto = new SystemUserDto();
        systemUserDto.setNameUser("Алексей");
        systemUserDto.setFamilyUser("Машновский");
        systemUserDto.setEmail("alex@i.ua");
        systemUserDto.setPasswordUser("1");
        systemUserDto.setPrivilegeId(1L);
        systemUserDto.setBranchId(1L);
        systemUserDto.setSubdivisionId(1L);
        id = userService.saveUser(systemUserDto);

        SystemUserDto systemUserDto2 = new SystemUserDto();
        systemUserDto2.setNameUser("Валерий");
        systemUserDto2.setFamilyUser("Невар");
        systemUserDto2.setEmail("nev@tut.by");
        systemUserDto2.setPasswordUser("1");
        systemUserDto2.setPrivilegeId(1L);
        systemUserDto2.setBranchId(1L);
        systemUserDto2.setSubdivisionId(1L);
        id2 = userService.saveUser(systemUserDto2);

        SystemUser systemUserByEmail = userService.findByEmail("alex@i.ua");
        Assert.assertEquals("Поиск пользователя по электронной почте",
                "alex@i.ua", systemUserByEmail.getEmail());
        SystemUser systemUserByEmail2 = userService.findByEmail("nev@tut.by");
        Assert.assertEquals("Поиск пользователя по электронной почте",
                "nev@tut.by", systemUserByEmail2.getEmail());
        systemUserRepository.delete(id2);
    }

    @After
    public void finish() {
        systemUserRepository.delete(id);
        final SystemUser one = systemUserRepository.findOne(id);
        assertNull(one);
    }
}
