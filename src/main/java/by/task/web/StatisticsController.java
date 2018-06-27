package by.task.web;

import by.task.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;


@Controller
public class StatisticsController {

    private final ProposalService pService;

    @Autowired
    public StatisticsController(ProposalService pService) {
        this.pService = pService;
    }

    @GetMapping("/statistics")
    public String proposalC(Model model) {
        Map<String, Long> st = pService.getStatistics();
        model.addAttribute("total", st.get("total"));
        model.addAttribute("done", st.get("done"));
        model.addAttribute("denied", st.get("denied"));
        model.addAttribute("pNew", st.get("total") - st.get("done") - st.get("denied"));
        return "statistics";
    }
}
