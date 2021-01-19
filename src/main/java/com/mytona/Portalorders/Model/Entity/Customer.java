package com.mytona.Portalorders.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private long customerId;
    private String firstName;
    private String secondName;
    private String address;
}