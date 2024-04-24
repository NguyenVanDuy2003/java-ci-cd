package com.example.customer.Service;

import com.example.customer.Model.Customer;
import com.example.customer.Repository.CustomerRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {



    @Autowired
    private CustomerRepository CustomerRepository;

    public List<Customer> getCustomers() {
        return CustomerRepository.findAll();
    }
    public Customer getCustomer(String id) {
        return CustomerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
    }

    public Customer createCustomer(Customer customer) {
        return CustomerRepository.save(customer);
    }

    public Customer updateCustomer(String id, Customer updatedCustomer) {
        Optional<Customer> optionalUser = CustomerRepository.findById(id);
        if (optionalUser.isPresent()) {
            return CustomerRepository.save(updatedCustomer);
        } else {
            throw new ResourceNotFoundException("Customer not found with id: " + id);
        }
    }
    public Customer deleteCustomer(String id ) {
        Customer userToDelete = CustomerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

        CustomerRepository.deleteById(id);
        return userToDelete;
    }
}
