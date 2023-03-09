package com.example.demoProject.DTO;

import java.time.LocalDate;

public class AccountResponseDTO {
    private int accId;

    private double accNo;



    private LocalDate accCreatedDate;
    private long accBalance;
    private String accName;
    private int customerId;

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

    public long getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(long accBalance) {
        this.accBalance = accBalance;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }
}
