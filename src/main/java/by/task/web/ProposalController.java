package by.task.web;

import by.task.service.ProposalService;
import by.task.service.dto.ProposalDTO;
import by.task.service.util.AddNewStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProposalController {

    private final ProposalService pService;

    @Autowired
    public ProposalController(ProposalService pService) {
        this.pService = pService;
    }

    @GetMapping("/proposals")
    public String proposalC(Model model) {
        List<ProposalDTO> listP = pService.findAll();
        model.addAttribute("listP", listP);
        return "proposals";
    }

    @GetMapping(value = "/proposal/{id}")
    public String proposalById(Model model, @PathVariable("id") Long a){
        ProposalDTO proposalDTO = pService.findById(a);
        model.addAttribute("pr", proposalDTO);
        return "proposal";
    }

    @PostMapping(value = "/proposals")
    public String updateDTO(String status, Model model, Long id){
        ProposalDTO pr  = pService.findById(id);
        pr.setStatus(status);
        pr = AddNewStatus.newStatus(pr);
        pService.update(pr);
        List<ProposalDTO> listP = pService.findAll();
        model.addAttribute("listP", listP);
        return "proposals";
    }
}
