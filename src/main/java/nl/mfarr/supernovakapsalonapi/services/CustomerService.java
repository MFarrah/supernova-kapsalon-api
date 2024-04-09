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

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDto createCustomer(CustomerDto customerDto) {
        CustomerEntity customer = convertToEntity(customerDto);
        customer = customerRepository.save(customer);
        return convertToDto(customer);
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
        // Conversion logic here
        return customer;
    }

    private CustomerDto convertToDto(CustomerEntity customer) {
        CustomerDto customerDto = new CustomerDto();
        // Conversion logic here
        return customerDto;
    }
}
