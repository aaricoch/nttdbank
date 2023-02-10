package pe.com.nttdbank.Infrastructure.Interfaces;

import java.util.List;

import pe.com.nttdbank.Domain.Entities.Customer;

public interface ICustomerRepository {
    List<Customer> getAll();

    Customer getById(Long id);

    Boolean Create(Customer customer);

    Boolean Edit(Customer customer);

    Boolean Delete(Long id);
}
