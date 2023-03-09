package com.example.demoProject.JPA;

import com.example.demoProject.Model.Account;
import com.example.demoProject.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDate;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer>
{

    List<Transaction> findByAccount_AccNoAndTransactionTypeAndTransactionDate(long accNo,String transactionType,LocalDate transactionDate);
    List<Transaction> findByAccount_AccNo(long accNo);
    List<Transaction> findByAndAccount_AccNoAndTransactionType(long accNo,String transactionType);
    List<Transaction> findByAndAccount_AccNoAndTransactionDate(long accNo,LocalDate transactionDate);

}

