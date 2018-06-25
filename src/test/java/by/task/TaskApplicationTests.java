package by.task;

import by.task.repository.dao.CustomerRepository;
import by.task.repository.dao.ProposalRepository;
import by.task.repository.entity.Customer;
import by.task.repository.entity.Proposal;
import by.task.repository.entity.Role;
import by.task.repository.entity.Status;
import by.task.service.CustomerService;
import by.task.service.ProposalService;
import by.task.service.dto.CustomerDTO;
import by.task.service.dto.ProposalDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskApplicationTests {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProposalService proposalService;

    @Autowired
    private CustomerService customerService;

    @Test
    public void repositoryRequests() {

        log.info("Create new customer");
        Customer customer1 = Customer.customerBuilder()
                .setName("Misha")
                .setRole(Role.CUSTOMER)
                .build();
        customerRepository.save(customer1);

        log.info("Create new proposal");
        Proposal proposal1 = Proposal.builder()
                .setRequest("Test is doing!")
                .setDib(102.03)
                .setStatus(Status.NEW)
                .setDueDate(LocalDateTime.now().plusDays(2))
                .setCustomer(customer1)
                .build();
        proposalRepository.save(proposal1);

        log.info("Search proposal by ID");
        Proposal proposal = proposalRepository.findOne(proposal1.getId());

        log.info("Search customer by ID");
        Customer customer = customerRepository.findOne(customer1.getId());

        log.info("Update proposal by ID");
        Proposal proposalToUpdate = proposalRepository.findOne(proposal1.getId());
        proposalToUpdate.setStatus(Status.DONE);
        proposalToUpdate.setDoneDate(LocalDateTime.now());
        proposalRepository.save(proposalToUpdate);

        log.info("Search all proposal");
        Iterable<Proposal> proposalList = proposalRepository.findAll();

        log.info("Search all customer");
        Iterable<Customer> customerList = customerRepository.findAll();

        log.info("Search all proposal by status");
        List<Proposal> proposalList1 = proposalRepository.findAllByStatus(Status.NEW);

        log.info("Delete proposal by Object");
        proposalRepository.delete(proposalToUpdate);

        log.info("Delete customer by Object");
        customerRepository.delete(customer1);
    }

    @Test
    public void serviceRequests() {

        log.info("Create new customerDTO");
        CustomerDTO customerDTO1 = CustomerDTO.newBuilder()
                .setName("Gena")
                .setRole("customer")
                .build();
        customerDTO1=customerService.saveAndReturn(customerDTO1);

        log.info("Create new proposalDTO");
        ProposalDTO proposalDTO1 = ProposalDTO.builder()
                .setRequest("Test is doing!")
                .setDib(102.03)
                .setStatus("new")
                .setDueDate(LocalDateTime.now().plusDays(2))
                .setCustomerDTO(customerDTO1)
                .build();
        proposalService.save(proposalDTO1);

        log.info("Search all proposalDTO");
        List<ProposalDTO> proposalDTOList = proposalService.findAll();
        log.info("Search all customerDTO");
        List<CustomerDTO> customerDTOList = customerService.findAll();

        log.info("Search proposalDTO by ID");
        Long id1 = proposalDTOList.get(proposalDTOList.size()-1).getId();
        ProposalDTO proposalDTO = proposalService.findById(id1);

        log.info("Search customerDTO by ID");
        Long id = customerDTOList.get(customerDTOList.size()-1).getId();
        CustomerDTO customerDTO = customerService.findById(id);

        log.info("Update proposalDTO");
        proposalDTO.setStatus("DONE");
        proposalDTO.setDeniedDate(LocalDateTime.now().plusSeconds(5));
        proposalDTO.setDoneDate(LocalDateTime.now().plusSeconds(10));
        proposalService.update(proposalDTO);

        //delete after test
        Proposal proposal = proposalRepository.findOne(id1);
        Customer customer = customerRepository.findOne(id);
        proposalRepository.delete(id1);
        customerRepository.delete(id);
    }

    @Test
    public void madeRequests() {

        log.info("Search customerDTOs by Role");
        List<CustomerDTO> customerDTOs1 = customerService.getAllCustomerOnly();

        log.info("Search by Id fetch:Eager");
        Customer c = customerRepository.findByIdFetchEagerly(2L);

        log.info("Search all proposal by status");
        Long l = proposalService.countProposalsByStatusLike("NEW");
    }
}
