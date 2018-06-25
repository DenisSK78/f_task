package by.task.service.util;

import by.task.service.dto.ProposalDTO;

import java.time.LocalDateTime;
import java.util.Locale;


public class AddNewStatus {
    public static ProposalDTO newStatus(ProposalDTO p){
        switch (p.getStatus().toUpperCase(Locale.ENGLISH)){
            case "NEW": break;
            case "DONE": p.setDoneDate(LocalDateTime.now()); break;
            case "DENIED": p.setDeniedDate(LocalDateTime.now()); break;
        }
        return p;
    }
}
