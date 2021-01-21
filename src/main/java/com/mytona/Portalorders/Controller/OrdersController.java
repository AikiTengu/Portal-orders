package com.mytona.Portalorders.Controller;

import com.mytona.Portalorders.Model.DAO.OrderDAO;
import com.mytona.Portalorders.Model.Entity.*;
import com.mytona.Portalorders.Service.CustomerInfo;
import com.mytona.Portalorders.Service.DeliveryInfo;
import com.mytona.Portalorders.Service.PaymentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {


    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    CustomerInfo customerInfo;

    @Autowired
    DeliveryInfo deliveryInfo;

    @Autowired
    PaymentInfo paymentInfo;

    @GetMapping("/{orderId}")
    public OrderItem get(@PathVariable("orderId") long orderId) {
        OrderItem orderItem = new OrderItem();
        Order order = orderDAO.findOrder(orderId);
        Customer customer = customerInfo.getCustomer(order.getCustomerId());
        Delivery delivery = deliveryInfo.getDelivery(order.getDeliveryId());
        Payment payment = paymentInfo.getPayment(order.getPaymentId());


        orderItem.setOrderId(order.getOrderId());
        orderItem.setDeliveryId(order.getDeliveryId());
        orderItem.setPaymentId(order.getPaymentId());
        orderItem.setConfirmed(order.isConfirmed());

        if (customer != null) {
            orderItem.setCustomerFirstName(customer.getFirstName());
            orderItem.setCustomerSecondName(customer.getSecondName());
            orderItem.setCustomerAddress(customer.getAddress());
        }

        if (delivery != null) {
            orderItem.setDeliveryType(delivery.getDeliveryType());
            orderItem.setDeliveryDate(delivery.getDate());
            orderItem.setDeliveryAddress(delivery.getAddress());
            orderItem.setDelivered(delivery.isDelivered());
        }

        if (payment != null){
            orderItem.setPaymentDate(payment.getDate());
        orderItem.setCurrencyType(payment.getCurrencyType());
        orderItem.setSum(payment.getSum());
        }

        return orderItem;
    }

    @GetMapping("/all")
    public List<Order> getAll(){
        return orderDAO.findAll();
    }


    @PostMapping
    public Order save(@RequestBody Order order){
        return orderDAO.save(order);
    }

    @DeleteMapping("/{orderId}")
    public String remove(@PathVariable("orderId") long orderId){
        return orderDAO.deleteOrder(orderId);
    }

}
