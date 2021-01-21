package com.mytona.Portalorders.Controller;

import com.mytona.Portalorders.Model.DAO.OrderDAO;
import com.mytona.Portalorders.Model.Entity.Customer;
import com.mytona.Portalorders.Model.Entity.Order;
import com.mytona.Portalorders.Model.Entity.OrderItem;
import com.mytona.Portalorders.Service.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {


    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    CustomerInfo customerInfo;

    @GetMapping("/{orderId}")
    public OrderItem get(@PathVariable("orderId") long orderId) {
        OrderItem orderItem = new OrderItem();
        Order order = orderDAO.findOrder(orderId);
        Customer customer = customerInfo.getCustomer(order.getCustomerId());

        orderItem.setOrderId(order.getOrderId());
        orderItem.setDeliveryId(order.getDeliveryId());
        orderItem.setPaymentId(order.getPaymentId());

        orderItem.setCustomerFirstName(customer.getFirstName());
        orderItem.setCustomerSecondName(customer.getSecondName());
        orderItem.setCustomerAddress(customer.getAddress());
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
