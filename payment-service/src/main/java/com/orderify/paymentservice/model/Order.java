package com.orderify.paymentservice.model;

public class Order {
    private String orderId;
    private String productName;
    private int quantity;

    // Getter ve Setter'lar
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{orderId='" + orderId + "', productName='" + productName + "', quantity=" + quantity + '}';
    }
}
