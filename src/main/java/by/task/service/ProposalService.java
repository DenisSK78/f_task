package by.task.service;

import by.task.service.dto.ProposalDTO;

import java.util.Map;

public interface ProposalService extends GenericServiceMethod<ProposalDTO>{
    Long countProposalsByStatusLike(String s);
    Map<String, Long> getStatistics();
}
