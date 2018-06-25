package by.task.service.util;

import by.task.repository.entity.Proposal;
import by.task.service.dto.ProposalDTO;

import java.util.ArrayList;
import java.util.List;

public class ConvertProposalList {

    public static List<Proposal> toProposalList(List<ProposalDTO> proposalDTOList){
        List<Proposal> proposalList = new ArrayList<>();
        if (proposalDTOList!=null) {
            for (ProposalDTO p : proposalDTOList) {
                proposalList.add(ConvertForProposal.toProposal(p));
            }
        }
        return proposalList;
    }

    public static List<ProposalDTO> toProposalDTOList(List<Proposal> proposalList) {
        List<ProposalDTO> proposalDTOList = new ArrayList<>();
        if (proposalList != null) {
            for (Proposal p : proposalList) {
                proposalDTOList.add(ConvertForProposal.toProposalDTO(p));
            }
        }
        return proposalDTOList;
    }
}
