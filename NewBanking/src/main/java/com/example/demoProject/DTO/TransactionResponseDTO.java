package com.example.demoProject.DTO;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


public class TransactionResponseDTO
{

private int transactionId;
private LocalDate transactionDate;

private String transactionType;

private double transactionAmount;



    private String transactionDescription;
private  long fromAccNo;
private long toAccNo;

    public TransactionResponseDTO() {
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

    public long getFromAccNo() {
        return fromAccNo;
    }

    public void setFromAccNo(long fromAccNo) {
        this.fromAccNo = fromAccNo;
    }

    public long getToAccNo() {
        return toAccNo;
    }

    public void setToAccNo(long toAccNo) {
        this.toAccNo = toAccNo;
    }
}
