package com.example.demoProject.Service;

import com.example.demoProject.DTO.BankRequestDTO;
import com.example.demoProject.DTO.BankResponseDTO;
import com.example.demoProject.JPA.BankRepository;
import com.example.demoProject.Model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankService
{


    @Autowired
    private BankRepository bankRepository;


    public BankResponseDTO postBanks(BankRequestDTO bankRequestDTO)
    {
        Bank bank = new Bank();
        bank.setBankId(bankRequestDTO.getBankId());
        bank.setBankName(bankRequestDTO.getBankName());
        bank.setBankIfscCode(bankRequestDTO.getBankIfscCode());
        bank.setBankBranchName(bankRequestDTO.getBankBranchName());
        bank=bankRepository.save(bank);
        BankResponseDTO bankResponseDTO= new BankResponseDTO();
        bankResponseDTO.setBankId(bank.getBankId());
        bankResponseDTO.setBankName(bank.getBankName());
        bankResponseDTO.setBankIfscCode(bank.getBankIfscCode());
        bankResponseDTO.setBankBranchName(bank.getBankBranchName());
        return bankResponseDTO;
    }




    public List<BankResponseDTO> getBankDetails()
    {
        List<Bank> bankList = bankRepository.findAll();
        List<BankResponseDTO> bankResponseDTOS= new ArrayList<>();
        for (Bank bank:bankList)
        {
            BankResponseDTO bankResponseDTO= new BankResponseDTO();
            bankResponseDTO.setBankId(bank.getBankId());
            bankResponseDTO.setBankName(bank.getBankName());
            bankResponseDTO.setBankIfscCode(bank.getBankIfscCode());
            bankResponseDTO.setBankBranchName(bank.getBankBranchName());
            bankResponseDTOS.add(bankResponseDTO);
        }
        return bankResponseDTOS;
    }

    public BankResponseDTO getSingleBank(int id)
    {
        Bank bank=bankRepository.findById(id).orElse(null);
        BankResponseDTO bankResponseDTO= new BankResponseDTO();
        bankResponseDTO.setBankId(bank.getBankId());
        bankResponseDTO.setBankName(bank.getBankName());
        bankResponseDTO.setBankIfscCode(bank.getBankIfscCode());
        bankResponseDTO.setBankBranchName(bank.getBankBranchName());
        return bankResponseDTO;
    }




}
