package pe.com.nttdbank.Domain.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue
    private Long customerID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personID", foreignKey = @ForeignKey(name = "FK_Customer_Person_personID"))
    private Person person;
    private String customerSegment;

    public Customer() {
        super();
        person = new Person();
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getCustomerSegment() {
        return customerSegment;
    }

    public void setCustomerSegment(String customerSegment) {
        this.customerSegment = customerSegment;
    }
}
