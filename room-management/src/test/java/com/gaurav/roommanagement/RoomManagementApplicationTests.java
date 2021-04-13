package com.gaurav.roommanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.gaurav.roommanagement.model.Room;
import com.gaurav.roommanagement.repository.RoomRepo;
import com.gaurav.roommanagement.service.RoomService;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class RoomManagementApplicationTests {

	@Autowired
	private RoomService service;
	
	@MockBean
	private RoomRepo repository;
	
	@Test
	public void findAllRoomsTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Room("a","b","c",1),new Room("e","f","g",1)).collect(Collectors.toList()));
		assertEquals(2,service.findAllRooms().size());
	}
	
	@Test
	public void  addRoomTest() {
		Room room = new Room("a","b","c",1);
		when(repository.save(room)).thenReturn(room);
		assertEquals(room, service.addRoom(room));
	}
	
	@Test
	public void deleteRoomTest() {
		@SuppressWarnings("unused")
		Room room = new Room("a","b","c",1);
		service.deleteAllRooms();
		verify(repository, times(1)).deleteAll();
		
	}
	

}


