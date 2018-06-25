package by.task.service;

import by.task.service.dto.CustomerDTO;

import java.util.List;

public interface CustomerService extends GenericServiceMethod<CustomerDTO> {
    CustomerDTO saveAndReturn(CustomerDTO o);
    List<CustomerDTO> getAllCustomerOnly();
    CustomerDTO searchByIdWithProposal(Long id);
}
