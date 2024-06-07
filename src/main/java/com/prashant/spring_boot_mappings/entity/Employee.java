package com.prashant.spring_boot_mappings.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPLOYEE_TBL")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String dept;
    @JsonManagedReference
    @OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_add", referencedColumnName = "address_id")
    private Address address;

//    one emp can have multiple cc
    @OneToMany(targetEntity = CreditCard.class, cascade = CascadeType.ALL)
    private List<CreditCard> creditCards;

}
