package com.example.demoProject.Service;

import com.example.demoProject.DTO.CustomerRequestDTO;
import com.example.demoProject.DTO.CustomerResponseDTO;
import com.example.demoProject.JPA.CustomerRepository;
import com.example.demoProject.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;



    public CustomerResponseDTO postCustomer(CustomerRequestDTO customerRequestDTO)
    {
        Customer customer = new Customer();
        CustomerResponseDTO  customerResponseDTO = new CustomerResponseDTO();
        customer.setCustomerId(customerRequestDTO.getCustomerId());
        customer.setCustomerName(customerRequestDTO.getCustomerName());
        customer.setCustomerPhoneNumber(customerRequestDTO.getCustomerPhoneNumber());
        customer.setEmailId(customerRequestDTO.getEmailId());
        Customer c = customerRepository.save(customer);
        customerResponseDTO.setCustomerId(c.getCustomerId());
        customerResponseDTO.setCustomerName(c.getCustomerName());
        customerResponseDTO.setCustomerPhoneNumber(c.getCustomerPhoneNumber());
        customerResponseDTO.setEmailId(c.getEmailId());
        return customerResponseDTO;
    }


    public List<CustomerResponseDTO> getCustomers()
    {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOList = new ArrayList<>();
        for(Customer customer:customerList){
            CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
            customerResponseDTO.setCustomerId(customer.getCustomerId());
            customerResponseDTO.setCustomerName(customer.getCustomerName());
            customerResponseDTO.setCustomerPhoneNumber(customer.getCustomerPhoneNumber());
            customerResponseDTO.setEmailId(customer.getEmailId());
            customerResponseDTOList.add(customerResponseDTO);
        }
        return customerResponseDTOList;
    }


    public CustomerResponseDTO getOneCustomer(int id)
    {
        Customer customer = customerRepository.findById(id).orElse(null);
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        customerResponseDTO.setCustomerId(customer.getCustomerId());
        customerResponseDTO.setCustomerName(customer.getCustomerName());
        customerResponseDTO.setCustomerPhoneNumber(customer.getCustomerPhoneNumber());
        customerResponseDTO.setEmailId(customer.getEmailId());
        return customerResponseDTO;
    }



    public CustomerResponseDTO putCustomers(CustomerRequestDTO customerRequestDTO,int id)
    {
        Customer customer= customerRepository.findById(id).orElse(null);
        customer.setCustomerName(customerRequestDTO.getCustomerName());
        customer=customerRepository.save(customer);
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        customerResponseDTO.setCustomerId(customer.getCustomerId());
        customerResponseDTO.setCustomerName(customer.getCustomerName());
        customerResponseDTO.setCustomerPhoneNumber(customer.getCustomerPhoneNumber());
        customerResponseDTO.setEmailId(customer.getEmailId());
        return customerResponseDTO;
    }









}
