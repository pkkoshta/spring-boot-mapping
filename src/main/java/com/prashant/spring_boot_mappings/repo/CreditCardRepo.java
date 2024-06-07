package com.prashant.spring_boot_mappings.repo;

import com.prashant.spring_boot_mappings.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepo extends JpaRepository<CreditCard, Integer> {
}
