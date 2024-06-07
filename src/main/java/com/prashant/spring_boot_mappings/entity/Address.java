package com.prashant.spring_boot_mappings.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ADDRESS_TBL")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer id;
    private String street;
    private String city;
    private long zipCode;

    @JsonBackReference
    @OneToOne(targetEntity = Employee.class, mappedBy = "address", fetch = FetchType.EAGER)
    private Employee employee;
}
