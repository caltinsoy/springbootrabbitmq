package com.example.springbootrabbitmq.producer;

import com.example.springbootrabbitmq.model.Order;
import com.example.springbootrabbitmq.model.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.springbootrabbitmq.util.RabbitMqConstants.EXCHANGE;
import static com.example.springbootrabbitmq.util.RabbitMqConstants.ROUTING_KEY;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/{restaurantName}")
    public String bookOrdeR(@RequestBody Order order, @PathVariable String restaurantName) {

        OrderStatus orderStatus = new OrderStatus(order, "GOING", "Successfull ordered" + restaurantName);
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, orderStatus);
        return "SUCCESS !";
    }

}
