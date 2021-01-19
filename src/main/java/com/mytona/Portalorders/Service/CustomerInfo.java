package com.mytona.Portalorders.Service;

import com.mytona.Portalorders.Model.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerInfo {

    @Autowired
    private RestTemplate restTemplate;

    public Customer getCustomer(long customerId) {
        Customer customer = restTemplate.getForObject("http://portal-customers/customers/" + customerId, Customer.class);
        return customer;
    }
}
