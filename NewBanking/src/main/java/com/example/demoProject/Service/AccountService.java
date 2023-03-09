package com.example.demoProject.Service;

import com.example.demoProject.DTO.AccountRequestDTO;
import com.example.demoProject.DTO.AccountResponseDTO;
import com.example.demoProject.JPA.AccountRepository;
import com.example.demoProject.JPA.BankRepository;
import com.example.demoProject.JPA.CustomerRepository;
import com.example.demoProject.Model.Account;
import com.example.demoProject.Model.Bank;
import com.example.demoProject.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BankRepository bankRepository;


    public Account postAccounts(AccountRequestDTO accountRequestDTO)
    {
        Customer customer = customerRepository.findById(accountRequestDTO.getCustomerId()).orElse(null);
        Bank bank=bankRepository.findById(accountRequestDTO.getBankId()).orElse(null);
        Account account=new Account();
        account.setCustomer(customer);
        account.setBank(bank);
        account.setAccNo(Long.parseLong(accountRequestDTO.getAccNo()));
        account.setAccName(customer.getCustomerName());
        account.setAccBankName(bank.getBankName());
        account.setAccCreatedDate(accountRequestDTO.getAccCreatedDate());
        account.setAccBalance(account.getAccBalance());
        account=accountRepository.save(account);
        return account;
    }

    public String putAmount(AccountRequestDTO accountRequestDTO)
    {
        Account account=accountRepository.findByCustomer_CustomerId(accountRequestDTO.getCustomerId());
        account=accountRepository.findById(accountRequestDTO.getAccId()).orElse(null);
        account.setAccBalance(accountRequestDTO.getAccBalance());
        account=accountRepository.save(account);
        return "Credited";
    }

    public Account getAccountDetails(int id)
    {
        Account account=accountRepository.findById(id).orElse(null);
        return account;

    }



}
