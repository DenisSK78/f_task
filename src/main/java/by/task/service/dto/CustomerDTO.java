package by.task.service.dto;

import java.util.List;

public class CustomerDTO {

    private Long id;
    private String name;
    private String role;
    private List<ProposalDTO> proposalDTOList;

    private CustomerDTO(CustomerDTOBuilder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.role = builder.role;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public List<ProposalDTO> getProposalDTOList() {
        return proposalDTOList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setProposalDTOList(List<ProposalDTO> proposalDTOList) {
        this.proposalDTOList = proposalDTOList;
    }

    public static CustomerDTOBuilder newBuilder(){
        return new CustomerDTOBuilder();
    }

    public static class CustomerDTOBuilder {
        private Long id;
        private String name;
        private String role;
        private List<ProposalDTO> proposalDTOList;

        public CustomerDTOBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public CustomerDTOBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CustomerDTOBuilder setRole(String role) {
            this.role = role;
            return this;
        }

        public CustomerDTOBuilder setProposalDTOList(List<ProposalDTO> proposalDTOList) {
            this.proposalDTOList = proposalDTOList;
            return this;
        }

        public CustomerDTO build(){
            return new CustomerDTO(this);
        }
    }
}
