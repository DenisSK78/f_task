package by.task.repository.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Embedded
    private static final long serialVersionUID = 5237416054426971182L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @OneToMany
    @JoinColumn(name = "customer_id")
    private List<Proposal> proposals;

    public Customer() {
    }

    public Customer(CustomerBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.role = builder.role;
        this.proposals = builder.proposal;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public List<Proposal> getProposals() {
        return proposals;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setProposals(List<Proposal> proposals) {
        this.proposals = proposals;
    }

    public static class CustomerBuilder{
        private Long id;
        private String name;
        private Role role;
        private List<Proposal> proposal;

        public CustomerBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public CustomerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder setRole(Role role) {
            this.role = role;
            return this;
        }

        public CustomerBuilder setProposal(List<Proposal> proposal) {
            this.proposal = proposal;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }

    public static CustomerBuilder customerBuilder(){
        return new CustomerBuilder();
    }
}
