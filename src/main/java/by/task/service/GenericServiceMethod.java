package by.task.service;

import java.util.List;

public interface GenericServiceMethod <V>{
    List<V> findAll();
    V findById(Long l);
    void update(V o);
    void save(V o);
    Long count();
}