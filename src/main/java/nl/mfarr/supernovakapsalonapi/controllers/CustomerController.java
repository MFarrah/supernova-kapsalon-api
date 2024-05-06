package nl.mfarr.supernovakapsalonapi.controllers;

import nl.mfarr.supernovakapsalonapi.dtos.CustomerDto;
import nl.mfarr.supernovakapsalonapi.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto createdCustomer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @PostMapping("/batch")
    public ResponseEntity<Iterable<CustomerDto>> createCustomers(@RequestBody Iterable<CustomerDto> customerDtos) {
        Iterable<CustomerDto> createdCustomers = customerService.createCustomers((List<CustomerDto>) customerDtos);
        return new ResponseEntity<>(createdCustomers, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CustomerDto>> getCustomerById(@PathVariable Long id) {
        Optional<CustomerDto> customerDto = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerDto);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<CustomerDto>> getCustomerByEmail(@PathVariable String email) {
        List<CustomerDto> customers = customerService.getCustomerByEmail(email);
        return ResponseEntity.ok(customers);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<CustomerDto> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CustomerDto> patchCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        CustomerDto patchedCustomer = customerService.patchCustomer(id, customerDto);
        return ResponseEntity.ok(patchedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}

