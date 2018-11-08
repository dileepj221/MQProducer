package com.example.demo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.vo.Customer;

@Component
public class MQProducer {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${sender.activemq.queue}")
	String queue;
	
	public void send(Customer customer){
		System.out.println("Sending meaage to queue:- "+queue);
		jmsTemplate.convertAndSend(queue, customer);
	}

}
