package com.orderify.paymentservice.messaging;

import com.orderify.paymentservice.model.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    @RabbitListener(queues = "orderQueue")
    public void consumeOrder(Order order) {
        System.out.println("✔ [PAYMENT SERVICE] Yeni sipariş alındı:");
        System.out.println("➡ ID: " + order.getOrderId());
        System.out.println("➡ Ürün: " + order.getProductName());
        System.out.println("➡ Adet: " + order.getQuantity());

        // Burada ödemeyi işleme alabilirsin (dummy ödeme işlemi yapılabilir)
    }
}
