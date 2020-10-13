package com.codegym.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(targetEntity = Customer.class)
    List<Customer> customers;
}
