package by.task.service.util;

import by.task.repository.entity.Customer;
import by.task.service.dto.CustomerDTO;

public class ConvertForCustomer {

    public static Customer toCustomer(CustomerDTO customerDTO){
        return Customer.customerBuilder()
                .setId(customerDTO.getId())
                .setName(customerDTO.getName())
                .setRole(ConvertRole.getEnumRole(customerDTO.getRole()))
                .setProposal(ConvertProposalList.toProposalList(customerDTO.getProposalDTOList()))
                .build();
    }

    public static CustomerDTO toCustomerDTO(Customer customer){
        return CustomerDTO.newBuilder()
                .setId(customer.getId())
                .setName(customer.getName())
                .setRole(customer.getRole().toString())
                .build();
    }
}
