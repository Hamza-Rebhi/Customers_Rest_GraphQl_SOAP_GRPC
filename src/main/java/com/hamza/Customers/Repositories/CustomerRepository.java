package com.hamza.Customers.Repositories;

import com.hamza.Customers.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer,Long> {
}
