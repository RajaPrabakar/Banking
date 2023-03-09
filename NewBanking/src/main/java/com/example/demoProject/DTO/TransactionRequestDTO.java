package com.example.demoProject.DTO;

import com.example.demoProject.ValidateTransactionDescription;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class TransactionRequestDTO
{
    private int customerId;
    private int accId;


//    @NotNull(message = "Enter the correctAccount Number")
    private long accNo;


    private int fromAccId;
    private int toAccId;

    private long fromAccNo;

    private double accBal;

    private long toAccNo;

    private int bankId;

    private int transactionId;
    @CreationTimestamp
    private LocalDate transactionDate;

    private String transactionType;


    private double transactionAmount;


    @ValidateTransactionDescription
    private String transactionDescription;


    public double getAccBal() {
        return accBal;
    }

    public void setAccBal(double accBal) {
        this.accBal = accBal;
    }

    public long getFromAccNo() {
        return fromAccNo;
    }

    public void setFromAccNo(long fromAccNo) {
        this.fromAccNo = fromAccNo;
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

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public long getToAccNo() {
        return toAccNo;
    }

    public void setToAccNo(long toAccNo) {
        this.toAccNo = toAccNo;
    }
    public int getFromAccId() {
        return fromAccId;
    }

    public void setFromAccId(int fromAccId) {
        this.fromAccId = fromAccId;
    }

    public int getToAccId() {
        return toAccId;
    }

    public void setToAccId(int toAccId) {
        this.toAccId = toAccId;
    }


    public long getAccNo() {
        return accNo;
    }

    public void setAccNo(long accNo) {
        this.accNo = accNo;
    }
}
