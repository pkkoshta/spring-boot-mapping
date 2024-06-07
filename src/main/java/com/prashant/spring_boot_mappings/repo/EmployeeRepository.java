package com.prashant.spring_boot_mappings.repo;

import com.prashant.spring_boot_mappings.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
