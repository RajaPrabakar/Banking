package com.example.demoProject.Controller;

import com.example.demoProject.DTO.BankRequestDTO;
import com.example.demoProject.DTO.BankResponseDTO;
import com.example.demoProject.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankController
{

    @Autowired
    private BankService bankService;


    @PostMapping(value = "/create-bank")
    public ResponseEntity<Object> createBanks(@RequestBody BankRequestDTO bankRequestDTO)
    {
        BankResponseDTO bankResponseDTO1 = bankService.postBanks(bankRequestDTO);
        return ResponseEntity.ok(bankResponseDTO1);

    }

    @GetMapping(value = "/get-bank")
    public ResponseEntity<Object> getBanks()
    {
        List<BankResponseDTO> bankResponseDTO= bankService.getBankDetails();
        return ResponseEntity.ok(bankResponseDTO);
    }


    @GetMapping(value = "/get-one-bank/{id}")
    public ResponseEntity<Object> getSingleBank(@PathVariable  int id)
    {
        BankResponseDTO bankResponseDTO= bankService.getSingleBank(id);
        return ResponseEntity.ok(bankResponseDTO);
    }






}
