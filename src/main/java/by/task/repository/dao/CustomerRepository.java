package by.task.repository.dao;

import by.task.repository.entity.Customer;
import by.task.repository.entity.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Override
    <S extends Customer> S save(S s);

    @Override
    Customer findOne(Long aLong);

    @Override
    boolean exists(Long aLong);

    @Override
    List<Customer> findAll();

    @Override
    long count();

    @Override
    void delete(Long aLong);

    List<Customer> roleLike(Role role);

    @Query("SELECT c FROM Customer c JOIN FETCH c.proposals WHERE c.id = (:id)")
    Customer findByIdFetchEagerly(@Param("id") Long id);
}
