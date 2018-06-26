package by.task.web;

import by.task.service.CustomerService;
import by.task.service.ProposalService;
import by.task.service.dto.CustomerDTO;
import by.task.service.dto.ProposalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class CustomerController {

    private final CustomerService cService;

    private final ProposalService pService;

    @Autowired
    public CustomerController(CustomerService cService, ProposalService pService) {
        this.cService = cService;
        this.pService = pService;
    }

    @GetMapping("/customers")
    public String customers(Model model) {
        List<CustomerDTO> listC = cService.getAllCustomerOnly();
        model.addAttribute("listC",listC);
        return "customers";
    }

    @GetMapping(value = "/customer/{id}")
    public String customerId(Model model, @PathVariable("id") Long id) {
        CustomerDTO cD = cService.searchByIdWithProposal(id);
        if (cD!=null) {
            model.addAttribute("cust", cD);
            model.addAttribute("listC", cD.getProposalDTOList());
        }else {
            cD = cService.findById(id);
            model.addAttribute("cust", cD);
        }
        return "customer";
    }

    @GetMapping(value = "new-proposal/{id}")
    public String newProposal(Model model, @PathVariable("id") Long id){
        CustomerDTO cD = cService.findById(id);
        model.addAttribute("cust", cD);
        return "new_proposal";
    }

    @PostMapping(value = "customer")
    public String addProposal(Long id, String request, Double dib, String time){
        CustomerDTO cDn = cService.findById(id);
        ProposalDTO pD = ProposalDTO.builder()
                .setRequest(request)
                .setDib(dib)
                .setStatus("NEW")
                .setStartDate(LocalDateTime.now())
                .setDueDate(LocalDateTime.parse(time))
                .setCustomerDTO(cDn)
                .build();
        pService.save(pD);
        return "redirect:/customer/"+id;
    }
}
