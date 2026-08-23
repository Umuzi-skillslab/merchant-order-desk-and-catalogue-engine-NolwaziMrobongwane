package com.paynestsystem.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    
    private int id;
    private Customer customer;
    private List<OrderItem> orderItems;

    public Order( int id, Customer customer) {

        if (id <= 0){
            throw new IllegalArgumentException("Order ID must be positive.");
        }
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }

        this.id = id;
        this.customer = customer;
        this.orderItems = new ArrayList<>();
    }

    public void addItem(Product product, int quantity){
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        OrderItem item = new OrderItem(product, quantity);
        orderItems.add(item);
    }

    public BigDecimal calculateTotal(){
        BigDecimal total = BigDecimal.ZERO;
        for (OrderItem item : orderItems) {
            total = total.add(item.calculateTotal());
        }
        return total;
    }

    public int getId(){
        return id;
    }
    public Customer getCustomer(){
        return customer;
    }
    public List<OrderItem> getOrderItems(){
        return Collections.unmodifiableList(orderItems);
    }
}
