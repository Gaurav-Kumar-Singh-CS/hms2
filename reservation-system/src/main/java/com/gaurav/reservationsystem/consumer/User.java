package com.gaurav.reservationsystem.consumer;

import org.springframework.stereotype.Component;
/*
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.gaurav.reservationsystem.config.MessagingConfig;
import com.gaurav.reservationsystem.model.Reservation;*/

@Component
public class User {

	/* @RabbitListener(queues = MessagingConfig.QUEUE)
	    public void consumeMessageFromQueue(Reservation newReservation) {
	        System.out.println("Reservations from queue : " + newReservation);
	    }*/
}
