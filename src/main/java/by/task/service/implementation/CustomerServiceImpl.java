package by.task.service.implementation;

import by.task.repository.dao.CustomerRepository;
import by.task.repository.entity.Customer;
import by.task.repository.entity.Role;
import by.task.service.CustomerService;
import by.task.service.dto.CustomerDTO;
import by.task.service.util.ConvertCustomerList;
import by.task.service.util.ConvertForCustomer;
import by.task.service.util.ConvertProposalList;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> findAll() {
        return ConvertCustomerList.customerDTOList(customerRepository.findAll());
    }

    @Override
    public CustomerDTO findById(Long l) {
        return ConvertForCustomer.toCustomerDTO(customerRepository.findOne(l));
    }

    @Override
    public void update(CustomerDTO o) {}

    @Override
    public CustomerDTO saveAndReturn(CustomerDTO o) {
        Customer customer = ConvertForCustomer.toCustomer(o);
        customerRepository.save(customer);
        return ConvertForCustomer.toCustomerDTO(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomerOnly() {
        return ConvertCustomerList.customerDTOList(customerRepository.roleLike(Role.CUSTOMER));
    }

    @Override
    public CustomerDTO searchByIdWithProposal(Long id) {
        Customer c = customerRepository.findByIdFetchEagerly(id);
        if (c!=null) {
            CustomerDTO cD = ConvertForCustomer.toCustomerDTO(c);
            if (c.getProposals()!=null)
            cD.setProposalDTOList(ConvertProposalList.toProposalDTOList(c.getProposals()));
            else cD.setProposalDTOList(Collections.emptyList());
            return cD;
        }
        return null;
    }

    @Override
    public void save(CustomerDTO o) {}

    @Override
    public Long count() {
        return null;
    }
}
