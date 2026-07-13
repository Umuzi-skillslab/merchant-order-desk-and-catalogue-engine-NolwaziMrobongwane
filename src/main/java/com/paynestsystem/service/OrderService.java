package com.paynestsystem.service;

import com.paynestsystem.domain.Order;
import com.paynestsystem.domain.OrderItem;

public class OrderService {

    public void printReceipt(Order order) {
        System.out.println("Order #:" + order.getId());
        System.out.println("Customer:" + order.getCustomer().getName());
        System.out.println("----------------------");

        for (OrderItem item : order.getOrderItems()) {
            System.out.println( item.getProduct().getName() + " x" + item.getQuantity());
        }

        System.out.println("----------------------");
        System.out.println( "Total: R" + order.calculateTotal());
    }
}
