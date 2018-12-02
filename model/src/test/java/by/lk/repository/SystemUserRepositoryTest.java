package by.lk.repository;

import by.lk.entity.Branch;
import by.lk.entity.Privilege;
import by.lk.entity.Subdivision;
import by.lk.entity.SystemUser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertNull;

public class SystemUserRepositoryTest extends CommonTest {

    private SystemUser id;
    private SystemUser id2;

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Test
    public void saveTest() {
        Set<Privilege> privileges = new HashSet<>();
        Privilege privilege = new Privilege();
        privilege.setId(1L);
        privileges.add(privilege);
        Branch branch = new Branch();
        branch.setId(1L);
        Subdivision subdivision = new Subdivision();
        subdivision.setId(1L);

        SystemUser systemUser = new SystemUser();
        systemUser.setNameUser("Виталий");
        systemUser.setFamilyUser("Ушаков");
        systemUser.setPasswordUser("1");
        systemUser.setEmail("v");
        systemUser.setPrivilege(privileges);
        systemUser.setBranch(branch);
        systemUser.setSubdivision(subdivision);

        id = systemUserRepository.save(systemUser);
        SystemUser userFromDb = systemUserRepository.findOne(id.getId());
        Assert.assertEquals("Сравнение двух ID: ", id.getId(), userFromDb.getId());
    }

    @Test
    public void findByEmailTest() {
        Set<Privilege> privileges = new HashSet<>();
        Privilege privilege = new Privilege();
        privilege.setId(1L);
        privileges.add(privilege);

        Branch branch = new Branch();
        branch.setId(1L);
        Subdivision subdivision = new Subdivision();
        subdivision.setId(1L);

        SystemUser systemUser = new SystemUser();
        systemUser.setNameUser("Евгений");
        systemUser.setFamilyUser("Беляков");
        systemUser.setPasswordUser("1");
        systemUser.setEmail("jen@gmail.com");
        systemUser.setPrivilege(privileges);
        systemUser.setBranch(branch);
        systemUser.setSubdivision(subdivision);

        SystemUser systemUser2 = new SystemUser();
        systemUser2.setNameUser("Ярослав");
        systemUser2.setFamilyUser("Зыскунов");
        systemUser2.setPasswordUser("1");
        systemUser2.setEmail("lk@gmail.com");
        systemUser2.setPrivilege(privileges);
        systemUser.setBranch(branch);
        systemUser.setSubdivision(subdivision);

        id = systemUserRepository.save(systemUser);
        id2 = systemUserRepository.save(systemUser2);
        SystemUser userFromDb = systemUserRepository.findByEmail("jen@gmail.com");
        Assert.assertEquals("Поиск электронной почты: ", id.getEmail(), userFromDb.getEmail());
        SystemUser userFromDb2 = systemUserRepository.findByEmail("lk@gmail.com");
        Assert.assertEquals("Поиск электронной почты: ", id2.getEmail(), userFromDb2.getEmail());
        systemUserRepository.delete(id2);
    }

    @After
    public void finish() {
        systemUserRepository.delete(id);
        final SystemUser one = systemUserRepository.findOne(id.getId());
        assertNull(one);
    }
}