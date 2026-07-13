package com.paynestsystem.domain;

public class OrderItem {
    
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double calculateTotal() {
        return product.getPrice() * quantity;
    }
}
