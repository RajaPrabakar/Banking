package com.example.demoProject.Controller;

import com.example.demoProject.CustomExceptionHandler;
import com.example.demoProject.DTO.TransactionRequestDTO;
import com.example.demoProject.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
public class TransactionController implements CustomExceptionHandler
{
    @Autowired
    private TransactionService transactionService;

    @PostMapping(value = "/create-transaction")
    public ResponseEntity<Object> postTransaction(@Valid @RequestBody TransactionRequestDTO transactionRequestDTO)
    {
        Object transaction= transactionService.postTransaction(transactionRequestDTO);
        return ResponseEntity.ok(transaction);
    }
    @PostMapping(value = "/post-account-transactions")
    public ResponseEntity<Object> createAccountTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO)
    {
       Object  transactions=transactionService.postTransactionAccountDetails(transactionRequestDTO);
        return ResponseEntity.ok(transactions);
    }

}
