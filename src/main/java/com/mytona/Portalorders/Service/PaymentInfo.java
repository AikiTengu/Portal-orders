package com.mytona.Portalorders.Service;

import com.mytona.Portalorders.Model.Entity.Customer;
import com.mytona.Portalorders.Model.Entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentInfo {

    @Autowired
    RestTemplate restTemplate;

    public Payment getPayment(long paymentId) {
        Payment payment = restTemplate.getForObject("http://portal-payment/payments/" + paymentId, Payment.class);
        return payment;
    }

}
