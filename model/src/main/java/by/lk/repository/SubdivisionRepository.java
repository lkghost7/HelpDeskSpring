package by.lk.repository;

import by.lk.entity.Subdivision;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubdivisionRepository extends CrudRepository<Subdivision, Long> {

    List<Subdivision> findAll();
}