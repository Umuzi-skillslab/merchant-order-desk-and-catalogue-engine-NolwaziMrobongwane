package com.paynestsystem.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
    
    private int id;
    private Customer customer;
    private List<OrderItem> orderItems;

    public Order( int id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.orderItems = new ArrayList<>();
    }

    public void addItem(Product product, int quantity){
        OrderItem item = new OrderItem(product, quantity);
        orderItems.add(item);
    }

    public double calculateTotal(){
        double total = 0;
        for (OrderItem item : orderItems) {
            total += item.calculateTotal();
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
        return orderItems;
    }
}
