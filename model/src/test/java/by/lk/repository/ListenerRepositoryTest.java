package by.lk.repository;

import by.lk.entity.Listener;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ListenerRepositoryTest extends CommonTest {

    @Autowired
    private ListenerRepository listenerRepository;

    @Test
    public void findAll() {
        List<Listener> all = listenerRepository.findAll();
        Assert.assertNotNull(all);
    }
}