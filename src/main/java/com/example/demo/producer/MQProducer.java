package com.example.demo.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.vo.Customer;

@Component
public class MQProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MQProducer.class);
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${sender.activemq.queue}")
	String queue;
	
	public void send(Customer customer){
		LOGGER.info("sending message='{}' to destination='{}'", customer, queue);
		jmsTemplate.convertAndSend(queue, customer);
	}

}
