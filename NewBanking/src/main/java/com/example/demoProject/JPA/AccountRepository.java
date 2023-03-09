package com.example.demoProject.JPA;

import com.example.demoProject.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

    Account findByCustomer_CustomerId(int id);
    Account findByAccNo(long accNo);
    Account findByAccId(int id);
}
