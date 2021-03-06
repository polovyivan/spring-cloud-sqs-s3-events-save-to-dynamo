package com.polovyi.ivan.controller;


import com.polovyi.ivan.dto.CustomerRequest;
import com.polovyi.ivan.dto.CustomerResponse;
import com.polovyi.ivan.service.CustomerService;
import com.polovyi.ivan.service.S3EventListenerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/customers")
public record CustomerController(CustomerService customerService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> getAllCustomers() {
        return customerService.getAllCustomers();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void getCreateCustomer(@RequestBody CustomerRequest customerRequest) {
         customerService.createCustomer(customerRequest);
    }

}
