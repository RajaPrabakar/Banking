package com.example.demoProject.Controller;

import com.example.demoProject.DTO.CustomerRequestDTO;
import com.example.demoProject.DTO.CustomerResponseDTO;
import com.example.demoProject.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController
{
    @Autowired
    private CustomerService customerService;


    @PostMapping(value = "/create-customers")
    public ResponseEntity<Object> createCustomers(@RequestBody CustomerRequestDTO customerRequestDTO)
    {
        CustomerResponseDTO customerResponseDTO = customerService.postCustomer(customerRequestDTO);
        return ResponseEntity.ok(customerResponseDTO);
    }

    @GetMapping(value = "/get-customers")
    public ResponseEntity<Object> getCustomers()
    {
        List<CustomerResponseDTO> customerResponseDTOList=customerService.getCustomers();
        return ResponseEntity.ok(customerResponseDTOList);
    }


    @GetMapping(value ="/get-one-customer/{id}")
    public ResponseEntity<Object> getSingleCustomer(@PathVariable int id)
    {
        CustomerResponseDTO customerResponseDTO= customerService.getOneCustomer(id);
        return ResponseEntity.ok(customerResponseDTO);
    }

    @PutMapping(value = "/update-customer/{id}")
    public ResponseEntity<Object> updateCustomer(@RequestBody CustomerRequestDTO customerRequestDTO,@PathVariable int id)
    {
        CustomerResponseDTO customerResponseDTO = customerService.putCustomers(customerRequestDTO,id);
        return ResponseEntity.ok(customerResponseDTO);
    }



}
