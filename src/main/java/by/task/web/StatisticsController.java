package by.task.web;

import by.task.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class StatisticsController {

    private final ProposalService pService;

    @Autowired
    public StatisticsController(ProposalService pService) {
        this.pService = pService;
    }

    @GetMapping("/statistics")
    public String proposalC(Model model) {
        Long pTotal = pService.count();
        Long pDone = pService.countProposalsByStatusLike("DONE");
        Long pDenied = pService.countProposalsByStatusLike("DENIED");
        Long pNew = pService.countProposalsByStatusLike("NEW");
        model.addAttribute("total", pTotal);
        model.addAttribute("done", pDone);
        model.addAttribute("denied", pDenied);
        model.addAttribute("pNew", pNew);
        return "statistics";
    }
}
