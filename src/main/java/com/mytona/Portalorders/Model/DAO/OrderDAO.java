package com.mytona.Portalorders.Model.DAO;

import com.mytona.Portalorders.Model.Entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAO {

    public static  final String HASH_KEY = "Order";

    @Autowired
    private RedisTemplate redisTemplate;


    public Order save(Order order){
        redisTemplate.opsForHash().put(HASH_KEY, order.getOrderId(),order);
        return order;
    }

    public List<Order> findAll(){
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Order findOrder(long orderId){
        return (Order) redisTemplate.opsForHash().get(HASH_KEY,orderId);
    }

    public String deleteOrder(long orderId){
        redisTemplate.opsForHash().delete(HASH_KEY, orderId);
        return "Deleted order";
    }
}

