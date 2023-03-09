package com.example.demoProject.DTO;

public class BankResponseDTO {
    private String bankName;
    private int bankIfscCode;
    private String bankBranchName;
    private int bankId;

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getBankIfscCode() {
        return bankIfscCode;
    }

    public void setBankIfscCode(int bankIfscCode) {
        this.bankIfscCode = bankIfscCode;
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }
}
