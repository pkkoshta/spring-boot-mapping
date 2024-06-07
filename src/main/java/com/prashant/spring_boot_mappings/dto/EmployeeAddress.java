package com.prashant.spring_boot_mappings.dto;

import com.prashant.spring_boot_mappings.entity.Address;
import com.prashant.spring_boot_mappings.entity.Employee;

public record EmployeeAddress(Employee employee, Address address) {
}
