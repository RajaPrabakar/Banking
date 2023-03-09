package com.example.demoProject.Model;


import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Random;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accId;
   private Long accNo;



    @CreationTimestamp
    private LocalDate accCreatedDate;

    private double accBalance=0.0;

        private String accName;
        private String accBankName;

    public String getAccBankName() {
        return accBankName;
    }

    public void setAccBankName(String accBankName) {
        this.accBankName = accBankName;
    }

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Bank bank;

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Long getAccNo() {
        return accNo;
    }

    public void setAccNo(Long accNo) {
        this.accNo = accNo;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }


    public LocalDate getAccCreatedDate() {
        return accCreatedDate;
    }

    public void setAccCreatedDate(LocalDate accCreatedDate) {
        this.accCreatedDate = accCreatedDate;
    }

    public double getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(double accBalance) {
        this.accBalance = accBalance;
    }

}
