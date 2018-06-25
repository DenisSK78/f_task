package by.task.service.dto;

import java.time.LocalDateTime;

public class ProposalDTO {
    private Long id;
    private String request;
    private Double dib;
    private String status;
    private LocalDateTime dueDate;
    private LocalDateTime startDate;
    private LocalDateTime deniedDate;
    private LocalDateTime doneDate;
    private CustomerDTO customerDTO;

    public ProposalDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getRequest() {
        return request;
    }

    public Double getDib() {
        return dib;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getDeniedDate() {
        return deniedDate;
    }

    public LocalDateTime getDoneDate() {
        return doneDate;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public void setDib(Double dib) {
        this.dib = dib;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setDeniedDate(LocalDateTime deniedDate) {
        this.deniedDate = deniedDate;
    }

    public void setDoneDate(LocalDateTime doneDate) {
        this.doneDate = doneDate;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public ProposalDTO(ProposalDTOBuilder builder) {
        this.id = builder.id;
        this.request = builder.request;
        this.dib = builder.dib;
        this.status = builder.status;
        this.dueDate = builder.dueDate;
        this.startDate = builder.startDate;
        this.deniedDate = builder.deniedDate;
        this.doneDate = builder.doneDate;
        this.customerDTO = builder.customerDTO;
    }

    public static ProposalDTOBuilder builder(){
        return new ProposalDTOBuilder();
    }

    public static class ProposalDTOBuilder{
        private Long id;
        private String request;
        private Double dib;
        private String status;
        private LocalDateTime dueDate;
        private LocalDateTime startDate;
        private LocalDateTime deniedDate;
        private LocalDateTime doneDate;
        private CustomerDTO customerDTO;

        public ProposalDTOBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public ProposalDTOBuilder setRequest(String request) {
            this.request = request;
            return this;
        }

        public ProposalDTOBuilder setDib(Double dib) {
            this.dib = dib;
            return this;
        }

        public ProposalDTOBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

        public ProposalDTOBuilder setDueDate(LocalDateTime dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public ProposalDTOBuilder setStartDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public ProposalDTOBuilder setDeniedDate(LocalDateTime deniedDate) {
            this.deniedDate = deniedDate;
            return this;
        }

        public ProposalDTOBuilder setDoneDate(LocalDateTime doneDate) {
            this.doneDate = doneDate;
            return this;
        }

        public ProposalDTOBuilder setCustomerDTO(CustomerDTO customerDTO) {
            this.customerDTO = customerDTO;
            return this;
        }

        public ProposalDTO build(){
            return new ProposalDTO(this);
        }
    }
}
