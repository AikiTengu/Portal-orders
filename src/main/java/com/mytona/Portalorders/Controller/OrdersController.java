package com.mytona.Portalorders.Controller;

import com.mytona.Portalorders.Model.DAO.OrderDAO;
import com.mytona.Portalorders.Model.Entity.Customer;
import com.mytona.Portalorders.Model.Entity.Order;
import com.mytona.Portalorders.Service.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//TODO: create, confirm, update, delete orders

@RestController
@RequestMapping("/orders")
public class OrdersController {


    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    CustomerInfo customerInfo;

    @GetMapping("/{orderId}")
    public Order get(@PathVariable("orderId") long orderId) {
        Order order = orderDAO.findOrder(orderId);
        Customer customer = customerInfo.getCustomer(order.getCustomerId());
        return order;
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
