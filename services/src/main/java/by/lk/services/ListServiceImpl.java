package by.lk.services;

import by.lk.entity.Listener;
import by.lk.repository.ListenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ListServiceImpl implements ListenerService {

    private final ListenerRepository listenerRepository;

    public ListServiceImpl(ListenerRepository listenerRepository) {
        this.listenerRepository = listenerRepository;
    }

    @Override
    public List<Listener> findAll() {
        return listenerRepository.findAll();
    }
}