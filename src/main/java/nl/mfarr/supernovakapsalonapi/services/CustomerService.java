package nl.mfarr.supernovakapsalonapi.services;

import nl.mfarr.supernovakapsalonapi.entities.CustomerEntity;
import nl.mfarr.supernovakapsalonapi.repositories.CustomerRepository;
import nl.mfarr.supernovakapsalonapi.dtos.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {


    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDto createCustomer(CustomerDto customerDto) {
        CustomerEntity customer = convertToEntity(customerDto);
        CustomerEntity savedCustomer = customerRepository.save(customer);
        return convertToDto(savedCustomer);
    }

    public Optional<CustomerDto> getCustomerById(Long id) {
        return customerRepository.findById(id).map(this::convertToDto);
    }

    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
        CustomerEntity customer = convertToEntity(customerDto);
        customer = customerRepository.save(customer);
        return convertToDto(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    private CustomerEntity convertToEntity(CustomerDto customerDto) {
        CustomerEntity customer = new CustomerEntity();
        customer.setName(customerDto.getName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setGender(customerDto.getGender());
        customer.setDateOfBirth(customerDto.getDateOfBirth());

        return customer;
    }

    private CustomerDto convertToDto(CustomerEntity customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhoneNumber(customer.getPhoneNumber());
        customerDto.setGender(customer.getGender());
        customerDto.setDateOfBirth(customer.getDateOfBirth());

        return customerDto;
    }
}