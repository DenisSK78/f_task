package by.task.service.implementation;

import by.task.repository.dao.ProposalRepository;
import by.task.repository.entity.Proposal;
import by.task.service.ProposalService;
import by.task.service.dto.ProposalDTO;
import by.task.service.util.ConvertForProposal;
import by.task.service.util.ConvertProposalList;
import by.task.service.util.ConvertStatus;
import by.task.service.util.ProposalUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposalServiceImpl implements ProposalService {

    private ProposalRepository proposalRepository;

    @Autowired
    public ProposalServiceImpl(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    @Override
    public List<ProposalDTO> findAll() {
        return ConvertProposalList.toProposalDTOList(proposalRepository.findAll());
    }

    @Override
    public ProposalDTO findById(Long l) {
        return ConvertForProposal.toProposalDTO(proposalRepository.findOne(l));
    }

    @Override
    public void update(ProposalDTO o) {
        Proposal p = proposalRepository.findOne(o.getId());
        ProposalUpdate.updateProposal(p, o);
        proposalRepository.save(p);
    }

    @Override
    public void save(ProposalDTO o){
        proposalRepository.save(ConvertForProposal.toProposal(o));
    }

    @Override
    public Long count() {
        return proposalRepository.count();
    }

    @Override
    public Long countProposalsByStatusLike(String s) {
        return proposalRepository.countProposalsByStatusLike(ConvertStatus.getEnumStatus(s));
    }
}
