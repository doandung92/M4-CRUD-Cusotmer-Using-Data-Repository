package com.codegym.service.customer;

import com.codegym.model.Customer;
import com.codegym.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICustomerService extends IService<Customer> {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
}
