package by.task.service.util;

import by.task.repository.entity.Proposal;
import by.task.service.dto.ProposalDTO;

import java.util.Objects;

public class ProposalUpdate {
    public static void updateProposal(Proposal p, ProposalDTO pd){
        if (!Objects.equals(p.getStatus().toString(), ConvertStatus.getEnumStatus(pd.getStatus())))
            p.setStatus(ConvertStatus.getEnumStatus(pd.getStatus()));
        if (pd.getDeniedDate()!=null)
            p.setDeniedDate(pd.getDeniedDate());
        if(pd.getDoneDate()!=null)
            p.setDoneDate(pd.getDoneDate());
    }
}
