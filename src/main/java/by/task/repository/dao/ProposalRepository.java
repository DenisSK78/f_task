package by.task.repository.dao;

import by.task.repository.entity.Proposal;
import by.task.repository.entity.Status;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

public interface ProposalRepository extends CrudRepository<Proposal, Long> {

    @Override
    <S extends Proposal> S save(S s);

    @Override
    Proposal findOne(Long aLong);

    @Override
    boolean exists(Long aLong);

    @Override
    List<Proposal> findAll();

    @Override
    long count();

    @Override
    void delete(Long aLong);

    List<Proposal> findAllByStatus(Status status);

    Long countProposalsByStatusLike(Status status);
}
