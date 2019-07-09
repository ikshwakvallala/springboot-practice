package com.example.customer.service;

import com.example.customer.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    public abstract boolean createCustomer(Customer customer);

    public abstract boolean updateCustomer(Customer customer);

    public abstract String getCustomerByID(int id);

    public abstract Customer getCustomerInfo(int id);

    public abstract void deleteCustomer(int customerId);

    public abstract List<Customer> getAllCustomers();
}
