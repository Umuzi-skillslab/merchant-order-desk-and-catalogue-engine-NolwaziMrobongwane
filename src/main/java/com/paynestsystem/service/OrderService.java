package com.paynestsystem.service;

import java.math.BigDecimal;
import com.paynestsystem.domain.Order;

public class OrderService {

    public BigDecimal calauclateTotal(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        return order.calculateTotal();
    }
}

