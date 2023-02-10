package pe.com.nttdbank.Application.Interfaces;

import java.util.List;

import pe.com.nttdbank.Application.Dtos.Customer.Request.CustomerRequestDto;
import pe.com.nttdbank.Application.Dtos.Customer.Response.CustomerResponseDto;
import pe.com.nttdbank.Domain.Entities.Customer;

public interface ICustomerApplication {
    List<Customer> getAll();

    CustomerResponseDto getById(Long id);

    Boolean Create(CustomerRequestDto customerDto);

    Boolean Edit(Long id, CustomerRequestDto customerDto);

    Boolean Delete(Long id);
}
