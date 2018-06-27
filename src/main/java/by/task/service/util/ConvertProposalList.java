package by.task.service.util;

import by.task.repository.entity.Proposal;
import by.task.service.dto.ProposalDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ConvertProposalList {

    public static List<Proposal> toProposalList(List<ProposalDTO> proposalDTOList){
        if (proposalDTOList!=null) {
            return proposalDTOList.stream()
                    .map(ConvertForProposal::toProposal)
                    .collect(toList());
        }
        return Collections.emptyList();
    }

    public static List<ProposalDTO> toProposalDTOList(List<Proposal> proposalList) {
        if (proposalList!=null) {
            return proposalList.stream()
                    .map(ConvertForProposal::toProposalDTO)
                    .collect(toList());
        }
        return Collections.emptyList();
    }
}
