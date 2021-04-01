package com.Rbabit.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Rabbit.mq.config.MessagingConfig;
import com.Rabbit.mq.dto.Customer;
import com.Rabbit.mq.service.Repository;

@Component
public class Consumer {
	@Autowired
    Repository repository;
    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(Customer customer) {
    	repository.save(customer);
    }

}
