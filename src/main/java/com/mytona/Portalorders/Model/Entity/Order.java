package com.mytona.Portalorders.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Order")
public class Order implements Serializable {

    @Id
    private long orderId;
    private long customerId;
    private long paymentId;
    private long deliveryId;
    private boolean approved;
}
