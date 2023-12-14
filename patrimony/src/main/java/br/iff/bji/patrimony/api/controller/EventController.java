package br.iff.bji.patrimony.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.iff.bji.patrimony.api.entity.Event;
import br.iff.bji.patrimony.api.service.EventService;

@RestController
public class EventController {
	@Autowired
	private EventService eventService;
	
	@RequestMapping(value = "createevent", method = RequestMethod.POST)
	public String createEvent(@RequestBody Event event) {
		return eventService.createEvent(event);
	}
	
	@RequestMapping(value = "readevents", method = RequestMethod.GET)
	public List<Event> readEvents() {
		return eventService.readEvents();
	}
	
	@RequestMapping(value = "updateevent", method = RequestMethod.PUT)
	public String updateEvent(@RequestBody Event event){
		return eventService.updateEvent(event);
	}
	
	@RequestMapping(value = "deleteevent", method = RequestMethod.DELETE)
	public String deleteEvent(@RequestBody Event event) {
		return eventService.deteleEvent(event);
	}
	
}
