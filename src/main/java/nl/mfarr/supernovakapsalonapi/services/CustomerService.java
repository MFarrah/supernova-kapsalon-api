package nl.mfarr.supernovakapsalonapi.services;

import nl.mfarr.supernovakapsalonapi.entities.CustomerEntity;
import nl.mfarr.supernovakapsalonapi.mappers.CustomerMapper;
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
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDto createCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = customerMapper.convertToEntity(customerDto);
        CustomerEntity savedCustomer = customerRepository.save(customerEntity);
        return customerMapper.convertToDto(savedCustomer);
    }

    public List<CustomerDto> createCustomers(List<CustomerDto> customerDtos) {
        return customerDtos.stream().map(this::createCustomer).collect(Collectors.toList());
    }

    public Optional<CustomerDto> getCustomerById(Long id) {
        return customerRepository.findById(id).map(customerMapper::convertToDto);
    }

    public List<CustomerDto> getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email).stream()
                .map(customerMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::convertToDto)
                .collect(Collectors.toList());
    }

   public CustomerDto patchCustomer(Long id, CustomerDto customerDto) {
        CustomerEntity customerEntity = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customerEntity.setName(customerDto.getName());
        customerEntity.setLastName(customerDto.getLastName());
        customerEntity.setDateOfBirth(customerDto.getDateOfBirth());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setPhoneNumber(customerDto.getPhoneNumber());
        customerEntity.setGender(customerDto.getGender());
        CustomerEntity savedCustomer = customerRepository.save(customerEntity);
        return customerMapper.convertToDto(savedCustomer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

}
