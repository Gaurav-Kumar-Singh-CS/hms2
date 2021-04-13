package com.gaurav.reservationsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gaurav.reservationsystem.model.Reservation;
import com.gaurav.reservationsystem.repository.ReservationRepo;
import com.gaurav.reservationsystem.service.ReservationService;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ReservationSystemApplicationTests {

	@Autowired
	private ReservationService service;
	
	@MockBean
	private ReservationRepo repository;
	
	@Test
	public void findAllReservationsTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Reservation("a","b","c"),new Reservation("e","f","g")).collect(Collectors.toList()));
		assertEquals(2,service.findAllReservations().size());
	}
	
	@Test
	public void  addReservationTest() {
		Reservation reservation = new Reservation("a","b","2021-04-10","2021-04-12",1,1,"e",16000);
		when(repository.save(reservation)).thenReturn(reservation);
		assertEquals(reservation, service.addReservation(reservation));
	}
	
	@Test
	public void deleteReservationTest() {
		@SuppressWarnings("unused")
		Reservation reservation = new Reservation("a","b","c");
		service.deleteReservation("a");
		verify(repository, times(1)).deleteById("a");
		
	}
	
	@Test
	public void findReservationByEmailTest() {
		String email = "b";
		Reservation reservation = new Reservation("a","b","c");
		when(repository.findByEmail(email)).thenReturn(reservation);
		assertEquals(reservation,service.findByEmail(email));
	}

}

