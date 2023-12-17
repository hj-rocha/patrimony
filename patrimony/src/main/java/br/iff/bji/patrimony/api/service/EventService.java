package br.iff.bji.patrimony.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.iff.bji.patrimony.api.entity.Event;
import br.iff.bji.patrimony.api.entity.TypeOfEvent;
import br.iff.bji.patrimony.api.repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Transactional
	public String createEvent(Event event) {
		try {
			if(!eventRepository.existsByName(event.getName())) {
				event.setId(null == eventRepository.findMaxId() ? 1 : eventRepository.findMaxId() + 1);
				eventRepository.save(event);
				return "Event created successfully.";
			} else {
				return "Event already exist in database.";
			}
		}catch(Exception e) {
			throw e;
		}
	}
	
	
	@Transactional
	public List<Event> readEvents(){
		return eventRepository.findAll();
	}
	
	@Transactional
	public String updateEvent(Event updatedEvent) {
		try {
			Event existingEvent = eventRepository.findById(updatedEvent.getId()).orElse(null);
			
			if(existingEvent == null) {
				return "Event not found with id:" + updatedEvent.getId();
			}
			
			String updatedName = updatedEvent.getName();
			String updatedDescription = updatedEvent.getDescription();
			TypeOfEvent updatedTypeOfEvent = updatedEvent.getTypeOfEvent();
			if((!existingEvent.getName().equals(updatedName) && eventRepository.existsByName(updatedName))
					|| (!existingEvent.getDescription().equals(updatedDescription) && eventRepository.existsByDescription(updatedDescription))) {
				return "Cannot update Event. Already exists same Name or Description from Event.";
			}
			
			existingEvent.setName(updatedName);
			existingEvent.setDescription(updatedDescription);
			existingEvent.setTypeOfEvent(updatedTypeOfEvent);
			eventRepository.save(existingEvent);
			
			return "Event updated successfully.";
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional
	public String deteleEvent(Event event) {
		try {
			eventRepository.deleteById(event.getId());
			return "Event record deleted successfully.";
		} catch (Exception e) {
			throw e;
		}
	}
}
