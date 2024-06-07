package com.prashant.spring_boot_mappings.controller;

import com.prashant.spring_boot_mappings.dto.AddressDTO;
import com.prashant.spring_boot_mappings.dto.EmployeeUpdate;
import com.prashant.spring_boot_mappings.entity.Address;
import com.prashant.spring_boot_mappings.entity.CreditCard;
import com.prashant.spring_boot_mappings.entity.Employee;
import com.prashant.spring_boot_mappings.repo.AddressRepository;
import com.prashant.spring_boot_mappings.repo.CreditCardRepo;
import com.prashant.spring_boot_mappings.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CreditCardRepo creditCardRepo;

    @PostMapping
    public void createEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);

    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Employee> getEmployee(@PathVariable Integer id){
        return Optional.ofNullable(employeeRepository.findById(id).get());
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody EmployeeUpdate employeeUpdate){
        Employee employee =  employeeRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Employee not found..."));
        employee.setFirstName(employeeUpdate.name());
        employee.setLastName(employeeUpdate.lastName());
        return employeeRepository.save(employee);
    }
    @PutMapping("/address/{id}")
    public void addressUpdate(@PathVariable Integer id, @RequestBody AddressDTO addressDTO){
        Address address = addressRepository.findById(id).
                    orElseThrow(() -> new IllegalArgumentException("Address not found..."));
        address.setStreet(addressDTO.street());
        address.setZipCode(addressDTO.zipCode());
        addressRepository.save(address);
    }

    @GetMapping("/address/{id}")
    public Address getEmpByAddessId(@PathVariable Integer id){
        return addressRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Address not found..."));
    }
}
