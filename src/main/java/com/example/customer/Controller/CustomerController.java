package com.example.customer.Controller;


import com.example.customer.Model.Customer;
import com.example.customer.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;



    @GetMapping("")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable String id) {
        return customerService.getCustomer(id);
    }


    @PostMapping("")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customer));
    }

    @PatchMapping("/{id}")
    public Customer updateCustomer(@PathVariable String id,@Valid @RequestBody Customer updatedCustomer) {
        return  customerService.updateCustomer(id, updatedCustomer);
    }
    @DeleteMapping("/{id}")
    public Customer deleteCustomer(@PathVariable String id) {
        return customerService.deleteCustomer(id);
    }
}
