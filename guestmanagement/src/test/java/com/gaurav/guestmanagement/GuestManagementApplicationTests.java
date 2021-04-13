package com.gaurav.guestmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gaurav.guestmanagement.model.Guest;
import com.gaurav.guestmanagement.repository.GuestRepo;
import com.gaurav.guestmanagement.service.GuestService;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class GuestManagementApplicationTests {

	@Autowired
	private GuestService service;
	
	@MockBean
	private GuestRepo repository;
	
	@Test
	public void findAllGuestsTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Guest("a","b","c","d"),new Guest("e","f","g","h")).collect(Collectors.toList()));
		assertEquals(2,service.findAllGuests().size());
	}
	
	@Test
	public void findGuestByIdTest() {
		String id = "a";
		Guest guest = new Guest("a","b","c","d");
		when(repository.findById(id)).thenReturn(Optional.of(guest));
		assertEquals(true,service.findGuestById(id).isPresent());
	}
	
	
	@Test
	public void  addGuestTest() {
		Guest guest = new Guest("a","b","c","d");
		when(repository.save(guest)).thenReturn(guest);
		assertEquals(guest, service.addGuest(guest));
	}
	
	@Test
	public void deleteGuestTest() {
		@SuppressWarnings("unused")
		Guest guest = new Guest("a","b","c","d");
		service.deleteGuest("a");
		verify(repository, times(1)).deleteById("a");
		
	}
	
	@Test
	public void findGuestByNameTest() {
		String name = "a";
		Guest guest = new Guest("a","b","c","d");
		when(repository.findByName(name)).thenReturn(guest);
		assertEquals(guest,service.findByName(name));
	}

}
