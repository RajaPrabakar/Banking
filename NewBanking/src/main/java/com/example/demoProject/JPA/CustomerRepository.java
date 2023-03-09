package com.example.demoProject.JPA;

import com.example.demoProject.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>
{
//    List<Customer> findByCustomer_CustomerId(int id);
}
