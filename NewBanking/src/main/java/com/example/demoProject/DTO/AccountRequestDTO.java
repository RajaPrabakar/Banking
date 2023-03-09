package com.example.demoProject.DTO;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Random;

public class AccountRequestDTO {
    private Integer accId;
    private double accNo;


    public String getAccNo(){
        Random rand = new Random();
        StringBuilder accountNum = new StringBuilder();
        for (int i=0; i <= 8; i++){
            int value = rand.nextInt(9);
            accountNum.append(value);
        }

        return accountNum.toString();
    }
    public void setAccNo(double accNo)
    {
        this.accNo=accNo;
    }

    @CreationTimestamp
    private LocalDate accCreatedDate;

    private double accBalance=0.0;
    private String accName;

    private int customerId;

    private int bankId;

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }
}
