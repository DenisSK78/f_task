package by.task.repository.entity;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "proposal")
public class Proposal implements Serializable {

    @Embedded
    private static final long serialVersionUID = 6511602928911266233L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "request")
    private String request;

    @Column(name = "dib")
    private Double dib;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    @Column(name = "denied_date")
    private LocalDateTime deniedDate;

    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    @Column(name = "done_date")
    private LocalDateTime doneDate;

    @ManyToOne
    private Customer customer;

    public Long getId() {
        return id;
    }

    public String getRequest() {
        return request;
    }

    public Double getDib() {
        return dib;
    }

    public Status getStatus() {
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

    public Customer getCustomer() {
        return customer;
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

    public void setStatus(Status status) {
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

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Proposal() {
    }

    public Proposal(ProposalBuilder proposalBuilder) {
        this.id = proposalBuilder.id;
        this.request = proposalBuilder.request;
        this.dib = proposalBuilder.dib;
        this.status = proposalBuilder.status;
        this.dueDate = proposalBuilder.dueDate;
        this.startDate = proposalBuilder.startDate;
        this.deniedDate = proposalBuilder.deniedDate;
        this.doneDate = proposalBuilder.doneDate;
        this.customer = proposalBuilder.customer;
    }

    public static ProposalBuilder builder(){
        return new ProposalBuilder();
    }

    public static class ProposalBuilder{
        private Long id;
        private String request;
        private Double dib;
        private Status status;
        private LocalDateTime dueDate;
        private LocalDateTime startDate;
        private LocalDateTime deniedDate;
        private LocalDateTime doneDate;
        private Customer customer;

        public ProposalBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public ProposalBuilder setRequest(String request) {
            this.request = request;
            return this;
        }

        public ProposalBuilder setDib(Double dib) {
            this.dib = dib;
            return this;
        }

        public ProposalBuilder setStatus(Status status) {
            this.status = status;
            return this;
        }

        public ProposalBuilder setDueDate(LocalDateTime dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public ProposalBuilder setStartDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public ProposalBuilder setDeniedDate(LocalDateTime deniedDate) {
            this.deniedDate = deniedDate;
            return this;
        }

        public ProposalBuilder setDoneDate(LocalDateTime doneDate) {
            this.doneDate = doneDate;
            return this;
        }

        public ProposalBuilder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Proposal build(){
            return new Proposal(this);
        }

    }
}
