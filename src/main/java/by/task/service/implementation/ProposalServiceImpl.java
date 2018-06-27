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
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void save(ProposalDTO o){
        proposalRepository.save(ConvertForProposal.toProposal(o));
    }

    @Override
    public ProposalDTO findById(Long l) {
        return ConvertForProposal.toProposalDTO(proposalRepository.findOne(l));
    }

    @Override
    public Long count() {
        return proposalRepository.count();
    }

    @Override
    public Long countProposalsByStatusLike(String s) {
        return proposalRepository.countProposalsByStatusLike(ConvertStatus.getEnumStatus(s));
    }

    @Override
    @Transactional
    public Map<String, Long> getStatistics() {
        Map<String, Long> map = new HashMap<>();
        map.put("total", proposalRepository.count());
        map.put("denied", proposalRepository.countProposalsByStatusLike(ConvertStatus.getEnumStatus("DENIED")));
        map.put("done", proposalRepository.countProposalsByStatusLike(ConvertStatus.getEnumStatus("DONE")));
        return map;
    }

    @Override
    public void update(ProposalDTO o) {
        Proposal p = proposalRepository.findOne(o.getId());
        ProposalUpdate.updateProposal(p, o);
        proposalRepository.save(p);
    }
}
