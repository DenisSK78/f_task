package by.task.service;

import by.task.service.dto.ProposalDTO;

public interface ProposalService extends GenericServiceMethod<ProposalDTO>{
    Long countProposalsByStatusLike(String s);
}
