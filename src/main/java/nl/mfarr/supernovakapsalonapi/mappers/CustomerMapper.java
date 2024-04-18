package nl.mfarr.supernovakapsalonapi.mappers;

import nl.mfarr.supernovakapsalonapi.dtos.CustomerDto;
import nl.mfarr.supernovakapsalonapi.entities.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerEntity convertToEntity(CustomerDto customerDto) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customerDto.getName());
        customerEntity.setLastName(customerDto.getLastName());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setPhoneNumber(customerDto.getPhoneNumber());
        customerEntity.setGender(customerDto.getGender());
        customerEntity.setDateOfBirth(customerDto.getDateOfBirth());

        return customerEntity;
    }

    public CustomerDto convertToDto(CustomerEntity customerEntity) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customerEntity.getId());
        customerDto.setName(customerEntity.getName());
        customerDto.setLastName(customerEntity.getLastName());
        customerDto.setEmail(customerEntity.getEmail());
        customerDto.setPhoneNumber(customerEntity.getPhoneNumber());
        customerDto.setGender(customerEntity.getGender());
        customerDto.setDateOfBirth(customerEntity.getDateOfBirth());

        return customerDto;
    }
}
