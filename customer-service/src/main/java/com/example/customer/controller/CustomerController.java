package com.example.customer.controller;

import com.example.customer.domain.Customer;
import com.example.customer.serviceImpl.CustomerServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @RequestMapping(value = "/getCustomerInfo/{customerId}",method = RequestMethod.GET)
    @ResponseBody
    public Customer getCustomerInfo(@PathVariable Integer customerId){
        Customer customer= customerServiceImpl.getCustomerInfo(customerId);
        return customer;

    }

    @RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getAllCustomers(){
        return customerServiceImpl.getAllCustomers();
    }

    @RequestMapping(value = "/insertCustomer",method = RequestMethod.PUT,headers = "Accept=application/json")
    @ResponseBody
    public HttpStatus insertCustomer(@RequestBody Customer customer ){
         Boolean insertStatus= customerServiceImpl.updateCustomer(customer);
        return insertStatus?HttpStatus.LOCKED:HttpStatus.BAD_REQUEST;

    }

    @RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT, headers = "Accept=application/json")
    @ResponseBody
    public HttpStatus updateCustomer(@RequestBody Customer customer) {
        return customerServiceImpl.updateCustomer(customer) ? HttpStatus.LOCKED : HttpStatus.BAD_REQUEST;
    }

    @RequestMapping(value = "/deleteCustomerById/{customerId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCustomer(@PathVariable Integer customerId) {
        customerServiceImpl.deleteCustomer(customerId);
    }

}
