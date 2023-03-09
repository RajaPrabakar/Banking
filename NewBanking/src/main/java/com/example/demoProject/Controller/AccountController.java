package com.example.demoProject.Controller;

import com.example.demoProject.DTO.AccountRequestDTO;
import com.example.demoProject.JPA.AccountRepository;
import com.example.demoProject.Model.Account;
import com.example.demoProject.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class AccountController {



    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/create-account")
    public ResponseEntity<Object> createAccounts(@RequestBody AccountRequestDTO accountRequestDTO)
    {
        Account account= accountService.postAccounts(accountRequestDTO);
        return ResponseEntity.ok(account);
    }

    @PostMapping(value ="/update-accountAmount")
    public ResponseEntity<Object> updateAmount(@RequestBody AccountRequestDTO accountRequestDTO)
    {
        String account=accountService.putAmount(accountRequestDTO);
        return ResponseEntity.ok(account);
    }

    @GetMapping(value = "/get-account/{id}")
    public ResponseEntity<Object> getAccount(@PathVariable int id)
    {
        Account account= accountService.getAccountDetails(id);
        return ResponseEntity.ok(account);
    }





}
