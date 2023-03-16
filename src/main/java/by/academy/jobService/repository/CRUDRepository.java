package by.academy.jobService.repository;

import java.util.List;

public interface CRUDRepository <K, T> {
    T findOne(K id);

    List<T> findAll();

    //K create(K object);

    T update(T object);

    void delete(K id);

    //User create(User object);
}
