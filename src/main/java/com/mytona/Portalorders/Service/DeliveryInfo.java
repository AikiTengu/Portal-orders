package com.mytona.Portalorders.Service;

import com.mytona.Portalorders.Model.Entity.Customer;
import com.mytona.Portalorders.Model.Entity.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeliveryInfo {

    @Autowired
    private RestTemplate restTemplate;

    public Delivery getDelivery(long deliveryId) {
        Delivery delivery = restTemplate.getForObject("http://portal-delivery/deliveries/" + deliveryId, Delivery.class);
        return delivery;
    }
}
