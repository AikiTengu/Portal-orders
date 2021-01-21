package com.mytona.Portalorders.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
    private long deliveryId;
    private String deliveryType;
    private LocalDate date;
    private String address;
    private boolean delivered;
}