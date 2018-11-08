package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.producer.MQProducer;
import com.example.demo.vo.Customer;

@SpringBootApplication
public class MqProducerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MqProducerApplication.class, args);
	}

	@Autowired
	MQProducer mqProducer;
	
	@Override
	public void run(String... args) throws Exception {
		Customer c = new Customer();
		c.setId(1l);
		c.setAge(22);
		c.setFirstname("Monika");
		c.setLastname("Kumari");
		
		mqProducer.send(c);
		
	}
}
