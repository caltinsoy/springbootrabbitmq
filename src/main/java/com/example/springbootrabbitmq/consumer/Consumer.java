package com.example.springbootrabbitmq.consumer;

import com.example.springbootrabbitmq.model.OrderStatus;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.example.springbootrabbitmq.util.RabbitMqConstants.QUEUE;

@Component
public class Consumer {

    private final Logger logger = Logger.getLogger(this.getClass());

    @RabbitListener(queues = QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        logger.info("Message consumed from queue " + orderStatus);
    }

}
