package com.example.demoProject.Service;

import com.example.demoProject.DTO.TransactionRequestDTO;
import com.example.demoProject.DTO.TransactionResponseDTO;
import com.example.demoProject.JPA.AccountRepository;
import com.example.demoProject.JPA.BankRepository;
import com.example.demoProject.JPA.CustomerRepository;
import com.example.demoProject.JPA.TransactionRepository;
import com.example.demoProject.Model.Account;
import com.example.demoProject.Model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private AccountRepository accountRepository;


    public Object postTransaction(TransactionRequestDTO transactionRequestDTO) {
        Map<String, String> hp = new HashMap<>();


        List<Transaction> fullTransaction = new ArrayList<>();

        Account fromAccNo = accountRepository.findByAccNo(transactionRequestDTO.getFromAccNo());
        Account toAccNo = accountRepository.findByAccNo(transactionRequestDTO.getToAccNo());
        if (fromAccNo == null && toAccNo == null && transactionRequestDTO.getTransactionAmount() > fromAccNo.getAccBalance()) {
            hp.put("Message", "Enter the correct Details for Transaction");
            return hp;
        } else if (fromAccNo == null) {
            hp.put("Message", "Enter the correct  From account Details");
            return hp;
        } else if (toAccNo == null) {
            hp.put("Message", "Enter the correct  To account Details");
            return hp;
        } else if (transactionRequestDTO.getTransactionAmount() > fromAccNo.getAccBalance()) {
            hp.put("Message", "Enter the correct Transaction Amount");
            return hp;
        } else if (fromAccNo == toAccNo) {
            hp.put("Message", "Enter the correct From Account and To Account number");
            return hp;
        } else if (fromAccNo.getAccNo() != null && toAccNo.getAccNo() != null && transactionRequestDTO.getTransactionAmount() < fromAccNo.getAccBalance()) {


            toAccNo.setAccBalance(toAccNo.getAccBalance() + transactionRequestDTO.getTransactionAmount());
            fromAccNo.setAccBalance(fromAccNo.getAccBalance() - transactionRequestDTO.getTransactionAmount());
            fromAccNo = accountRepository.save(fromAccNo);
            toAccNo = accountRepository.save(toAccNo);

            Transaction debitTransaction = new Transaction();
            Transaction creditTransaction = new Transaction();

            List<Transaction> transactionList = new ArrayList<>();

            debitTransaction.setTransactionType("Debited");
            debitTransaction.setTransactionAmount(transactionRequestDTO.getTransactionAmount());
            debitTransaction.setTransactionDescription(transactionRequestDTO.getTransactionDescription());
            debitTransaction.setTransactionDate(debitTransaction.getTransactionDate());
            debitTransaction.setFromAccNo(fromAccNo.getAccNo());
            debitTransaction.setToAccNo(toAccNo.getAccNo());
            debitTransaction.setCustomer(fromAccNo.getCustomer());
            debitTransaction.setAccount(fromAccNo);
            debitTransaction.setBank(fromAccNo.getBank());
            debitTransaction = transactionRepository.save(debitTransaction);

            creditTransaction.setTransactionType("Credited");
            creditTransaction.setTransactionDate(creditTransaction.getTransactionDate());
            creditTransaction.setTransactionAmount(transactionRequestDTO.getTransactionAmount());
            creditTransaction.setTransactionDescription(transactionRequestDTO.getTransactionDescription());
            creditTransaction.setFromAccNo(transactionRequestDTO.getFromAccNo());
            creditTransaction.setToAccNo(transactionRequestDTO.getToAccNo());
            creditTransaction.setCustomer(toAccNo.getCustomer());
            creditTransaction.setAccount(toAccNo);
            creditTransaction.setBank(toAccNo.getBank());
            creditTransaction = transactionRepository.save(creditTransaction);


        } else {
            hp.put("Message", "Enter the correct Details");
            return hp;
        }
        return "Transaction Completed";
    }

    public Object postTransactionAccountDetails(TransactionRequestDTO transactionRequestDTO) {

        List<TransactionResponseDTO> transactionResponseDTOList = new ArrayList<>();
        Map<String, List<TransactionResponseDTO>> map = new HashMap<>();

     if(transactionRequestDTO.getAccNo()!=0 && transactionRequestDTO.getTransactionType()!=null && transactionRequestDTO.getTransactionDate()!=null)
     {
         List<Transaction> transaction = transactionRepository.findByAccount_AccNoAndTransactionTypeAndTransactionDate(transactionRequestDTO.getAccNo(), transactionRequestDTO.getTransactionType(),transactionRequestDTO.getTransactionDate());
         for (Transaction transaction1 : transaction) {
             TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO();
             transactionResponseDTO.setTransactionId(transaction1.getTransactionId());
             transactionResponseDTO.setTransactionType(transaction1.getTransactionType());
             transactionResponseDTO.setTransactionDate(transaction1.getTransactionDate());
             transactionResponseDTO.setTransactionAmount(transaction1.getTransactionAmount());
             transactionResponseDTO.setTransactionDescription(transaction1.getTransactionDescription());
             transactionResponseDTO.setFromAccNo(transaction1.getFromAccNo());
             transactionResponseDTO.setToAccNo(transaction1.getToAccNo());
             transactionResponseDTOList.add(transactionResponseDTO);

         }
     }
       else if(transactionRequestDTO.getAccNo()!=0 && transactionRequestDTO.getTransactionType()!=null)
     {
         List<Transaction> transaction = transactionRepository.findByAndAccount_AccNoAndTransactionType(transactionRequestDTO.getAccNo(),transactionRequestDTO.getTransactionType());
         for (Transaction transaction1 : transaction) {
             TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO();
             transactionResponseDTO.setTransactionId(transaction1.getTransactionId());
             transactionResponseDTO.setTransactionType(transaction1.getTransactionType());
             transactionResponseDTO.setTransactionDate(transaction1.getTransactionDate());
             transactionResponseDTO.setTransactionAmount(transaction1.getTransactionAmount());
             transactionResponseDTO.setTransactionDescription(transaction1.getTransactionDescription());
             transactionResponseDTO.setFromAccNo(transaction1.getFromAccNo());
             transactionResponseDTO.setToAccNo(transaction1.getToAccNo());
             transactionResponseDTOList.add(transactionResponseDTO);

         }
     }
     else if(transactionRequestDTO.getAccNo()!=0 && transactionRequestDTO.getTransactionDate()!=null)
     {
         List<Transaction> transaction = transactionRepository.findByAndAccount_AccNoAndTransactionDate(transactionRequestDTO.getAccNo(),transactionRequestDTO.getTransactionDate());
         for (Transaction transaction1 : transaction) {
             TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO();
             transactionResponseDTO.setTransactionId(transaction1.getTransactionId());
             transactionResponseDTO.setTransactionType(transaction1.getTransactionType());
             transactionResponseDTO.setTransactionDate(transaction1.getTransactionDate());
             transactionResponseDTO.setTransactionAmount(transaction1.getTransactionAmount());
             transactionResponseDTO.setTransactionDescription(transaction1.getTransactionDescription());
             transactionResponseDTO.setFromAccNo(transaction1.getFromAccNo());
             transactionResponseDTO.setToAccNo(transaction1.getToAccNo());
             transactionResponseDTOList.add(transactionResponseDTO);

         }
     }
     else if( transactionRequestDTO.getAccNo()!=0 )
        {
            List<Transaction> transaction = transactionRepository.findByAccount_AccNo(transactionRequestDTO.getAccNo());
            for (Transaction transaction1 : transaction) {
                TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO();
                transactionResponseDTO.setTransactionId(transaction1.getTransactionId());
                transactionResponseDTO.setTransactionType(transaction1.getTransactionType());
                transactionResponseDTO.setTransactionDate(transaction1.getTransactionDate());
                transactionResponseDTO.setTransactionAmount(transaction1.getTransactionAmount());
                transactionResponseDTO.setTransactionDescription(transaction1.getTransactionDescription());
                transactionResponseDTO.setFromAccNo(transaction1.getFromAccNo());
                transactionResponseDTO.setToAccNo(transaction1.getToAccNo());
                transactionResponseDTOList.add(transactionResponseDTO);

            }

        }
      else {
            return "Enter correct Details";
        }
        map.put("TransactionList:", transactionResponseDTOList);
        return map;
    }
}

