package pe.com.nttdbank.Application.Services;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import pe.com.nttdbank.Application.Dtos.Customer.Request.CustomerRequestDto;
import pe.com.nttdbank.Application.Dtos.Customer.Response.CustomerResponseDto;
import pe.com.nttdbank.Application.Interfaces.ICustomerApplication;
import pe.com.nttdbank.Domain.Entities.Customer;
import pe.com.nttdbank.Domain.Entities.DocumentType;
import pe.com.nttdbank.Domain.Entities.Person;
import pe.com.nttdbank.Infrastructure.Repositories.CustomerRepository;

@ApplicationScoped
public class CustomerApplication implements ICustomerApplication {

    @Inject
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public CustomerResponseDto getById(Long id) {
        Customer customer = customerRepository.getById(id);
        if (customer == null) {
            throw new NullPointerException("Customer not fount");
        }
        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setNombre(customer.getPerson().getNames());
        customerResponseDto.setApellidoPaterno(customer.getPerson().getFirstLastName());
        customerResponseDto.setApellidoMaterno(customer.getPerson().getSecondLastName());
        customerResponseDto.setSegmento(customer.getCustomerSegment());
        customerResponseDto.setTipoDocumento(customer.getPerson().getDocumentType().getDocumentTypeCode());
        customerResponseDto.setNumeroDocumento(customer.getPerson().getDocumentNumber());

        return customerResponseDto;
    }

    @Override
    public Boolean Create(CustomerRequestDto customerDto) {
        Customer customer = new Customer();
        Person person = new Person();
        DocumentType document = new DocumentType();
        document.setDocumentTypeCode(customerDto.getTipoDocumento());
        person.setNames(customerDto.getNombre());
        person.setFirstLastName(customerDto.getApellidoPaterno());
        person.setSecondLastName(customerDto.getApellidoMaterno());
        person.setDocumentType(document);
        person.setDocumentNumber(customerDto.getNumeroDocumento());
        customer.setPerson(person);
        customer.setCustomerSegment(customerDto.getSegmento());

        return customerRepository.Create(customer);
    }

    @Override
    public Boolean Edit(Long id, CustomerRequestDto customerDto) {
        Customer customer = customerRepository.getById(id);
        if (customer == null) {
            throw new NullPointerException("Customer not fount");
        }

        Person person = new Person();
        DocumentType document = new DocumentType();
        document.setDocumentTypeCode(customerDto.getTipoDocumento());
        person.setNames(customerDto.getNombre());
        person.setFirstLastName(customerDto.getApellidoPaterno());
        person.setSecondLastName(customerDto.getApellidoMaterno());
        person.setDocumentType(document);
        person.setDocumentNumber(customerDto.getNumeroDocumento());
        customer.setPerson(person);
        customer.setCustomerSegment(customerDto.getSegmento());

        return customerRepository.Edit(customer);
    }

    @Override
    public Boolean Delete(Long id) {
        Customer customer = customerRepository.getById(id);
        if (customer == null) {
            throw new NullPointerException("Customer not fount");
        }

        return customerRepository.Delete(id);
    }
}
