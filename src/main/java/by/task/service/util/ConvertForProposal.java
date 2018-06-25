package by.task.service.util;

import by.task.repository.entity.Proposal;
import by.task.service.dto.ProposalDTO;

public class ConvertForProposal {

    public static Proposal toProposal(ProposalDTO proposalDTO){
        return Proposal.builder()
                .setId(proposalDTO.getId())
                .setRequest(proposalDTO.getRequest())
                .setDib(proposalDTO.getDib())
                .setStatus(ConvertStatus.getEnumStatus(proposalDTO.getStatus()))
                .setDueDate(proposalDTO.getDueDate())
                .setStartDate(proposalDTO.getDeniedDate())
                .setDeniedDate(proposalDTO.getDeniedDate())
                .setDoneDate(proposalDTO.getDoneDate())
                .setCustomer(ConvertForCustomer.toCustomer(proposalDTO.getCustomerDTO()))
                .build();
    }

    public static ProposalDTO toProposalDTO(Proposal proposal){
        return ProposalDTO.builder()
                .setId(proposal.getId())
                .setRequest(proposal.getRequest())
                .setStatus(proposal.getStatus().toString())
                .setDib(proposal.getDib())
                .setDueDate(proposal.getDueDate())
                .setStartDate(proposal.getStartDate())
                .setDeniedDate(proposal.getDeniedDate())
                .setDoneDate(proposal.getDoneDate())
                .build();
    }
}
