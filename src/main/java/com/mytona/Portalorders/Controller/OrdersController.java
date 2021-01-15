package com.mytona.Portalorders.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//TODO: create, confirm, update, delete orders

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @GetMapping("/{orderId}")
    public String getOrder(@PathVariable("orderId") String orderId) {
        return "Successfully retrieved an order:" + " " + orderId;
    }

}
