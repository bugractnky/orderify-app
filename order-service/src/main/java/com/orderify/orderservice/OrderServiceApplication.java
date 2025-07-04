package com.orderify.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

import com.orderify.orderservice.model.Order;

@SpringBootApplication
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadSampleOrders(OrderRepository orderRepository) {
        return args -> {
            if (orderRepository.count() == 0) {
                orderRepository.saveAll(Arrays.asList(
                    new Order("ORD-1001", "Laptop", 2),
                    new Order("ORD-1002", "Mouse", 10),
                    new Order("ORD-1003", "Keyboard", 5),
                    new Order("ORD-1004", "Monitor", 3),
                    new Order("ORD-1005", "USB Cable", 20),
                    new Order("ORD-1006", "Headphones", 7),
                    new Order("ORD-1007", "Webcam", 4),
                    new Order("ORD-1008", "Desk Lamp", 6),
                    new Order("ORD-1009", "Chair", 1),
                    new Order("ORD-1010", "Notebook", 15),
                    new Order("ORD-1011", "Smartphone", 8),
                    new Order("ORD-1012", "Tablet", 5),
                    new Order("ORD-1013", "Printer", 2),
                    new Order("ORD-1014", "Scanner", 1),
                    new Order("ORD-1015", "Router", 6),
                    new Order("ORD-1016", "Switch", 3),
                    new Order("ORD-1017", "External HDD", 4),
                    new Order("ORD-1018", "SSD", 9),
                    new Order("ORD-1019", "RAM", 12),
                    new Order("ORD-1020", "Graphics Card", 2),
                    new Order("ORD-1021", "Motherboard", 2),
                    new Order("ORD-1022", "CPU", 3),
                    new Order("ORD-1023", "Power Supply", 5),
                    new Order("ORD-1024", "Case", 2),
                    new Order("ORD-1025", "Cooling Fan", 10),
                    new Order("ORD-1026", "Microphone", 7),
                    new Order("ORD-1027", "Speakers", 6),
                    new Order("ORD-1028", "Projector", 1),
                    new Order("ORD-1029", "Whiteboard", 2),
                    new Order("ORD-1030", "Pen", 50),
                    new Order("ORD-1031", "Pencil", 40),
                    new Order("ORD-1032", "Eraser", 30),
                    new Order("ORD-1033", "Ruler", 20),
                    new Order("ORD-1034", "Stapler", 5),
                    new Order("ORD-1035", "Paper", 100),
                    new Order("ORD-1036", "Binder", 8),
                    new Order("ORD-1037", "Folder", 12),
                    new Order("ORD-1038", "Clipboard", 4),
                    new Order("ORD-1039", "Calculator", 3),
                    new Order("ORD-1040", "Desk Organizer", 2),
                    new Order("ORD-1041", "Trash Bin", 1),
                    new Order("ORD-1042", "Couch", 1),
                    new Order("ORD-1043", "Bookshelf", 2),
                    new Order("ORD-1044", "Coffee Machine", 1),
                    new Order("ORD-1045", "Water Dispenser", 1),
                    new Order("ORD-1046", "Clock", 2),
                    new Order("ORD-1047", "Coat Rack", 1),
                    new Order("ORD-1048", "TV", 1),
                    new Order("ORD-1049", "Remote Control", 2),
                    new Order("ORD-1050", "Extension Cord", 10)
                ));
            }
        };
    }
}
