package pe.com.nttdbank.Infrastructure.Repositories;

import java.util.Date;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import pe.com.nttdbank.Domain.Entities.Customer;
import pe.com.nttdbank.Domain.Entities.Person;
import pe.com.nttdbank.Infrastructure.Interfaces.ICustomerRepository;
//import pe.com.nttdbank.Utilities.StatusType;

@ApplicationScoped
public class CustomerRepository implements ICustomerRepository {

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = Customer.listAll();
        // List<Customer> customers = Customer.list("status", StatusType.Active);
        return customers;
    }

    @Override
    public Customer getById(Long id) {
        Customer customer = Customer.findById(id);
        return customer;
    }

    @Override
    @Transactional
    public Boolean Create(Customer customer) {
        Boolean result = false;
        Person person = customer.getPerson();
        person.persist();

        customer.setPerson(person);
        
        customer.persist();
        if (customer.isPersistent()) {
            result = true;
        }
        return result;
    }

    @Override
    @Transactional
    public Boolean Edit(Customer customer) {
        Boolean result = false;
        customer.AuditUpdateUser = 1;
        customer.AuditUpdateDate = new Date();
        customer.persist();
        if (customer.isPersistent()) {
            result = true;
        }
        return result;
    }

    @Override
    @Transactional
    public Boolean Delete(Long id) {
        Boolean result = false;
        Customer customer = getById(id);
        customer.State = 0;
        customer.AuditDeleteUser = 1;
        customer.AuditDeleteDate = new Date();
        customer.persist();
        if (customer.isPersistent()) {
            result = true;
        }
        return result;
    }

}
