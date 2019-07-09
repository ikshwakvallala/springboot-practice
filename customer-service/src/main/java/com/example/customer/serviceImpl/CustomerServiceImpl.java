package com.example.customer.serviceImpl;

import com.example.customer.domain.Customer;
import com.example.customer.repository.AddressRepository;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public boolean createCustomer(Customer customer) {
        return customerRepository.save(customer)!=null;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
         addressRepository.save(customer.getAddress());
        return customerRepository.save(customer)!=null;
    }

    @Override
    public String getCustomerByID(int id) {
        String str = customerRepository.getOne(id).toString();
        JsonParser jsonParser = new JsonParser();
        JsonObject objectFromString = jsonParser.parse(str).getAsJsonObject();
        System.out.println("CustomerDetails---->" + objectFromString);
        return String.valueOf(objectFromString);
    }

    @Override
    public Customer getCustomerInfo(int id) {
        return customerRepository.getOne(id);
    }

    @Override
    public void deleteCustomer(int customerId) {
         customerRepository.deleteById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
